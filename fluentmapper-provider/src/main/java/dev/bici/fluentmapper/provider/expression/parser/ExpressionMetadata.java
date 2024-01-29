package dev.bici.fluentmapper.provider.expression.parser;

/**
 * <p>Representation of a parsed <code>Expression</code>, containing the <code>accessed property</code>
 * from the lambda or method reference, the <code>source</code> and <code>target</code> types of the
 * expression.</p>
 *
 * @param property    the property accessed / returned by the expression
 * @param sourceClass the qualified class name of the input parameter's type
 * @param targetClass the qualified class name of the accessed property
 */
public record ExpressionMetadata(
        String property,
        String sourceClass,
        String targetClass
) {

    @Override
    public String toString() {
        return property + ";" + sourceClass + ";" + targetClass;
    }
}
