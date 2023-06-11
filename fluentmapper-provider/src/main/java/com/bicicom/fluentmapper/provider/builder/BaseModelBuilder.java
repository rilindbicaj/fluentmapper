package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.expression.Expression;
import com.bicicom.fluentmapper.provider.expression.parser.CachedConcurrentExpressionParser;
import com.bicicom.fluentmapper.provider.expression.parser.ExpressionMetadata;
import com.bicicom.fluentmapper.provider.expression.parser.ExpressionParser;

abstract class BaseModelBuilder {

    protected final ExpressionParser parser;

    protected BaseModelBuilder() {
        this.parser = CachedConcurrentExpressionParser.withCachedExtractor();
    }

    protected <S, T> ExpressionMetadata parse(Expression<S, T> expression) {
        return this.parser.parse(expression);
    }

}
