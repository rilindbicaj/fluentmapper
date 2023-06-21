package com.bicicom.fluentmapper.model.builder;

import com.bicicom.fluentmapper.expression.Expression;

import java.util.Collection;

public interface ModelBuilder<S> {

    /**
     * Specifies the primary key of the model.
     *
     * @param expression
     * @param <T>
     * @return a builder for the specified primary key's configuration
     */

    <T> KeyConfigurationBuilder<S, T> hasKey(Expression<S, T> expression);

    PropertyConfigurationBuilder property(Expression<S, ?> expression);

    TableConfigurationBuilder toTable(String tableName);

    <T> OneRelationshipConfigurationBuilder<T, S> hasOne(Expression<S, T> expression);

    <T> ManyRelationshipConfigurationBuilder<T, S> hasMany(Expression<S, Collection<T>> expression);

}
