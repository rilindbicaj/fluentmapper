package com.bicicom.fluentmapper.model.builder;

import com.bicicom.fluentmapper.expression.Expression;

public interface ManyToManyConfigurationBuilder<S, T> {

    JoinTableConfigurationBuilder joinOnTable(String tableName);

    ManyToManyConfigurationBuilder<S, T> mappedBy(Expression<S, T> propertyExpression);

}
