package dev.bici.fluentmapper.provider.expression.classextractor;

import java.lang.invoke.SerializedLambda;

/**
 * Parses the serialized form of <code>Expression</code> to extract its generic parameters, S and T,
 * representing the source - the input parameter - and the target - the returned property. Necessary due to
 * type erasure.
 */

public interface ExpressionClassExtractor {

    /**
     * Extracts the qualified class names of an expression's parameter and return type.
     *
     * @param expression       the <code>SerializedLambda</code> instance representing the expression
     * @param accessedProperty the property the expression accesses and returns
     * @return a String array with exactly two qualified class names, the first being the input parameter's class,
     * the second being the returned value's
     */

    String[] extract(SerializedLambda expression, String accessedProperty);

}
