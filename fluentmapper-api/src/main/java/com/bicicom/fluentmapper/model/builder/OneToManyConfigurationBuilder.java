package com.bicicom.fluentmapper.model.builder;

import com.bicicom.fluentmapper.expression.Expression;

public interface OneToManyConfigurationBuilder<S, T> {

    /**
     * Specifies the property by which to order the relationship. Whatever this means.
     *
     * @param propertyExpression
     * @return the builder
     */
    OneToManyConfigurationBuilder<S, T> orderBy(Expression<S, ?> propertyExpression);

    /**
     * Specifies the property in S which maps the relationship.
     *
     * @param propertyExpression
     * @return the builder
     */
    OneToManyConfigurationBuilder<S, T> mappedBy(Expression<S, T> propertyExpression);

    OneToManyConfigurationBuilder<S, T> fetch(FetchType fetchType);

}

