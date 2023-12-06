package com.bicicom.fluentmapper.provider.expression.parser;

import com.bicicom.fluentmapper.expression.Expression;
import com.bicicom.fluentmapper.provider.core.classloader.ModelClassLoader;
import com.bicicom.fluentmapper.provider.expression.classextractor.ExpressionClassExtractor;
import com.bicicom.fluentmapper.provider.expression.classextractor.RegexExpressionClassExtractor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import java.util.stream.StreamSupport;

/**
 * Handles parsing of {@link Expression} objects into {@link ExpressionMetadata} records.
 */

public abstract class ExpressionParser {

    protected final ExpressionClassExtractor classExtractor = RegexExpressionClassExtractor.INSTANCE;
    protected final ModelClassLoader modelClassLoader = ModelClassLoader.INSTANCE;

    /**
     * Extracts the {@code SerializedLambda} instance returned from a serialized lambda expression's
     * implementing class via the {@code writeReplace} method. By accepting an {@code Expression} instance,
     * the method makes sure {@code writeReplace} exists, since it's both serializable and a functional interface.
     * This method is unlikely to change, due to the lambda serialization mechanism being stable.
     *
     * @param expression the {@code Expression} instance
     * @return the {@code SerializedLambda} instance with metadata on the input expression
     */
    protected static SerializedLambda toSerializedLambda(final Expression<?, ?> expression) {
        try {
            final Method writeReplaceMethod = expression.getClass().getDeclaredMethod("writeReplace");
            writeReplaceMethod.setAccessible(true);

            return (SerializedLambda) writeReplaceMethod.invoke(expression);
        } catch (ReflectiveOperationException e) {
            throw new ExpressionParseException("Could not extract SerializedLambda from the provided expression;", e);
        }
    }

    /**
     * Given a {@link MethodNode} representation of an {@link Expression}, finds the first class property being accessed
     * inside it's bytecode instructions, if any.
     *
     * @param expressionNode the {@link MethodNode} whose instructions should be checked
     * @return a String representing the accessed property's name
     * @throws ExpressionParseException if the expression has no field access instruction present.
     */
    protected static String findAccessedProperty(final MethodNode expressionNode) throws ExpressionParseException {
        var node = StreamSupport.stream(expressionNode.instructions.spliterator(), false)
                .filter(instruction -> instruction.getOpcode() == Opcodes.GETFIELD)
                .findFirst()
                .orElseThrow(() -> new ExpressionParseException(
                        "No field access instruction found in method node " + expressionNode.name
                ));
        return ((FieldInsnNode) node).name;
    }

    /**
     * Parses an {@link Expression} object, extracting the accessed property, and source/target classes,
     * into an instance of {@link ExpressionMetadata}. Valid {@code Expression} instances for parsing are -
     * <ol>
     *     <li>Method references pointing to a class <code>getter</code></li>
     *     <li>Lambda expressions accessing and returning an object's field directly</li>
     * </ol>
     * <p>
     * The following examples show the correct way of declaring expressions valid for parsing.
     *
     * <pre>
     *     {@code Expression<User,Integer> idExpression = (user) -> user.id;}
     *     {@code Expression<User,Integer> idExpression = User::getId;}
     * </pre>
     * <p>
     * The parser can accept these expressions, returning an {@code ExpressionMetadata} instance from the
     * parsed and bundles metadata.
     *
     * <pre>
     *     {@code ExpressionMetadata idExpressionMetadata = expressionParser.parse(idExpression);}
     * </pre>
     *
     * @param expression the expression instance to be parsed
     * @return the expression's relevant metadata, bundled in an object
     */

    public abstract ExpressionMetadata parse(Expression<?, ?> expression);

}
