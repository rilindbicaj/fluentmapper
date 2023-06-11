package com.bicicom.fluentmapper.model.builder;

import com.bicicom.fluentmapper.expression.Expression;

public interface ModelBuilder<S> {

    <T> KeyConfigurationBuilder<S, T> hasKey(Expression<S, T> expression);

    PropertyConfigurationBuilder property(Expression<S, ?> expression);

    TableConfigurationBuilder toTable(String tableName);

    <T> PartialOneRelationshipConfigurationBuilder<T, S> hasOne(Expression<S, T> expression);

    <T> PartialManyRelationshipConfigurationBuilder hasMany(Expression<S, T> expression);
}
