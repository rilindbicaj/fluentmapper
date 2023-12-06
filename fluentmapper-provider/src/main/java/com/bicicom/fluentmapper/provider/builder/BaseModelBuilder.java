package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.expression.Expression;
import com.bicicom.fluentmapper.provider.expression.parser.CachingConcurrentExpressionParser;
import com.bicicom.fluentmapper.provider.expression.parser.ExpressionMetadata;
import com.bicicom.fluentmapper.provider.expression.parser.ExpressionParser;

abstract class BaseModelBuilder {

    /**
     * The parser to be used for extracting {@link ExpressionMetadata} objects from passed {@link Expression} objects.
     * A single instance is kept, in order to utilize the caching mechanism.
     */
    protected static final ExpressionParser expressionParser = new CachingConcurrentExpressionParser();

}
