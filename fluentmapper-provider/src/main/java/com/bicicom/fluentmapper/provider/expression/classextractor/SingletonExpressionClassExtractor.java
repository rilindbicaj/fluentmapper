package com.bicicom.fluentmapper.provider.expression.classextractor;

import com.bicicom.fluentmapper.provider.core.loader.ModelClassloader;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.regex.Pattern;

public final class SingletonExpressionClassExtractor implements ExpressionClassExtractor {

    private static final ExpressionClassExtractor parser = new SingletonExpressionClassExtractor();
    private static final ModelClassloader modelClassloader = ModelClassloader.instance();
    private final Pattern bracketLPattern = Pattern.compile("(\\(L|\\)L)");
    private final Pattern divisorPattern = Pattern.compile("/");

    private SingletonExpressionClassExtractor() {
        if (parser != null) {
            throw new IllegalStateException(getClass().getName() + " instance already exists.");
        }
    }

    public static ExpressionClassExtractor instance() {
        return parser;
    }

    private String getAccessedPropertyTypeName(String property, String containingClass) throws Exception {
        final Field field = Class.forName(containingClass, false, modelClassloader.getClassloader())
                .getDeclaredField(property);

        if (Collection.class.isAssignableFrom(field.getType())) {
            return ((ParameterizedType) field
                    .getGenericType())
                    .getActualTypeArguments()[0]
                    .getTypeName();
        }

        return field.getType().getTypeName();
    }

    private String[] parseMethodReference(final String refClass, final String property) {
        final String[] values = new String[2];

        values[0] = divisorPattern.matcher(refClass).replaceAll(".");

        try {
            values[1] = getAccessedPropertyTypeName(property, values[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

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
     * @param implMethodName
     * @return
     */

    private boolean isLambda(final String implMethodName) {
        return implMethodName.startsWith("lambda$");
    }

    private String[] parseLambda(final String implMethodSignature, final String property) {
        final String[] values;

        String bracketLess = bracketLPattern.matcher(implMethodSignature).replaceAll("");
        String divisorless = divisorPattern.matcher(bracketLess).replaceAll(".");

        values = divisorless.split(";");
        try {
            values[1] = getAccessedPropertyTypeName(property, values[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return values;
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
