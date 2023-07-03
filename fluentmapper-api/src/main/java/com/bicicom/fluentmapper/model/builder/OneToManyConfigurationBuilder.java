package com.bicicom.fluentmapper.model.builder;

import com.bicicom.fluentmapper.expression.Expression;

public interface OneToManyConfigurationBuilder<S, T> {

    /**
     * Specifies the property in the related entity which maps this relationship. If this
     * is not configured explicitly, the default option will be chosen.
     *
     * @param propertyExpression the property accessing expression
     * @return the builder for chaining calls
     */
    OneToManyConfigurationBuilder<S, T> mappedBy(Expression<T, S> propertyExpression);

}
