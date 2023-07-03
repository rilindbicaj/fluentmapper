package com.bicicom.fluentmapper.model.builder;

import com.bicicom.fluentmapper.expression.Expression;

import java.util.Collection;

public interface ManyRelationshipConfigurationBuilder<T, S> {

    OneToManyConfigurationBuilder<S, T> withOne(Expression<T, S> propertyExpression);

    ManyToManyConfigurationBuilder<S, T> withMany(Expression<T, Collection<S>> propertyExpression);

}
