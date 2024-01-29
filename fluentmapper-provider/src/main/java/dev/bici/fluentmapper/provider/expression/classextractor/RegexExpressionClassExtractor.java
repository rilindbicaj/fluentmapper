package dev.bici.fluentmapper.provider.expression.classextractor;

import dev.bici.fluentmapper.provider.core.classloader.ModelClassLoader;
import dev.bici.fluentmapper.provider.expression.parser.ExpressionParseException;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.regex.Pattern;

public enum RegexExpressionClassExtractor implements ExpressionClassExtractor {

    INSTANCE;

    /**
     * Regex pattern which matches JVM notation for method return types.
     */
    private final Pattern bracketLPattern = Pattern.compile("(\\(L|\\)L)");
    /**
     * Regex pattern which quite simply matches divisors. Used to separate classnames.
     */
    private final Pattern divisorPattern = Pattern.compile("/");
    /**
     * The classloader to be used for loading model classes.
     */
    private final ModelClassLoader modelClassLoader = ModelClassLoader.INSTANCE;

    private String getAccessedPropertyTypeName(String property, String containingClass) {
        final Field propertyField;

        try {
            propertyField = this.modelClassLoader
                    .getClassLoader()
                    .loadClass(containingClass)
                    .getDeclaredField(property);
        } catch (ClassNotFoundException e) {
            throw new ExpressionParseException(
                    "Could not crack class of property " + property + ". Containing class "
                            + containingClass + " is not present in the classloader.");
        } catch (NoSuchFieldException e) {
            throw new ExpressionParseException("Property " + property + " is not contained in class " + containingClass);
        }

        if (Collection.class.isAssignableFrom(propertyField.getType())) {
            return ((ParameterizedType) propertyField
                    .getGenericType())
                    .getActualTypeArguments()[0]
                    .getTypeName();
        }

        return propertyField.getType().getTypeName();
    }

    private String[] parseMethodReference(final String refClass, final String property) {
        final String[] values = new String[2];

        values[0] = divisorPattern.matcher(refClass).replaceAll(".");
        values[1] = getAccessedPropertyTypeName(property, values[0]);

        return values;
    }

    /**
     * Checks if a <code>SerializedLambda</code> refers to a lambda expression, by
     * checking the name of its implementing method. Serialized lambda expression
     * method names start with <code>lambda$</code>, whereas method references
     * directly refer to the method they represent.
     * </br>
     *
     * <p>This method would break in case a referenced method starts with <code>lambda$</code>,
     * * which is highly unlikely. It can also break if the compiler doesn't label lambdas with
     * * this prefix.</p>
     *
     * @param implMethodName the compiler-generated name of the method
     * @return true if the method is a lambda expression, false otherwise
     */

    private boolean isLambda(final String implMethodName) {
        return implMethodName.startsWith("lambda$");
    }

    private String[] parseLambda(final String implMethodSignature, final String property) {
        final String[] values;
        final String modelClassname;
        final String propertyClassname;

        String bracketLess = bracketLPattern.matcher(implMethodSignature).replaceAll("");
        String divisorLess = divisorPattern.matcher(bracketLess).replaceAll(".");

        values = divisorLess.split(";");

        modelClassname = values[0];
        propertyClassname = getAccessedPropertyTypeName(property, values[0]);

        return new String[]{modelClassname, propertyClassname};
    }

    @Override
    public String[] extract(SerializedLambda expression, String accessedProperty) {
        if (isLambda(expression.getImplMethodName())) {
            return parseLambda(expression.getImplMethodSignature(), accessedProperty);
        } else {
            return parseMethodReference(expression.getImplClass(), accessedProperty);
        }
    }
}
