package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.expression.Expression;
import com.bicicom.fluentmapper.provider.expression.parser.CachedConcurrentExpressionParser;
import com.bicicom.fluentmapper.provider.expression.parser.ExpressionMetadata;
import com.bicicom.fluentmapper.provider.expression.parser.ExpressionParser;

abstract class BaseModelBuilder {

    /**
     * Ensures all model builders use the same parser to utilize caching
     */
    private static final ExpressionParser parser;

    static {
        parser = CachedConcurrentExpressionParser.withExtractor();
    }

    protected BaseModelBuilder() {
    }

    protected <S, T> ExpressionMetadata parse(Expression<S, T> expression) {
        return parser.parse(expression);
    }

}
