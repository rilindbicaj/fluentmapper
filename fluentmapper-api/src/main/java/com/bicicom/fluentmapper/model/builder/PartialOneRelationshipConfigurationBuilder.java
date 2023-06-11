package com.bicicom.fluentmapper.model.builder;

import com.bicicom.fluentmapper.expression.Expression;

import java.util.Collection;

public interface PartialOneRelationshipConfigurationBuilder<S, T> {

    <U> OneToOneRelationshipConfigurationBuilder<S, T, U> withOne(Expression<S, U> expression);

    <U> OneToManyConfigurationBuilder<S, T, U> withMany(Expression<S, Collection<T>> expression);

}
