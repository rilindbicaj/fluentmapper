package dev.bici.fluentmapper.provider.builder;

import dev.bici.fluentmapper.expression.Expression;
import dev.bici.fluentmapper.provider.expression.parser.CachingConcurrentExpressionParser;
import dev.bici.fluentmapper.provider.expression.parser.ExpressionMetadata;
import dev.bici.fluentmapper.provider.expression.parser.ExpressionParser;

abstract class BaseModelBuilder {

    /**
     * The parser to be used for extracting {@link ExpressionMetadata} objects from passed {@link Expression} objects.
     * A single instance is kept, in order to utilize the caching mechanism.
     */
    protected static final ExpressionParser expressionParser = new CachingConcurrentExpressionParser();

    protected BaseModelBuilder() {
    }

}
