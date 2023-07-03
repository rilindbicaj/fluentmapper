package com.bicicom.fluentmapper.model.builder;

import com.bicicom.fluentmapper.expression.Expression;

public interface JoinColumnConfigurationBuilder extends ColumnConfigurationBuilder {

    <S> JoinColumnConfigurationBuilder referencing(Expression<S, ?> propertyExpression);

    JoinColumnConfigurationBuilder referencing(String referencedColumnName);

    JoinColumnConfigurationBuilder withLength(int length);

    JoinColumnConfigurationBuilder isRequired();

    JoinColumnConfigurationBuilder isRequired(boolean value);

    JoinColumnConfigurationBuilder isUnique();

    JoinColumnConfigurationBuilder isUnique(boolean value);

}
