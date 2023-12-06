package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.expression.Expression;
import com.bicicom.fluentmapper.model.builder.JoinColumnConfigurationBuilder;
import com.bicicom.fluentmapper.provider.model.JoinColumn;

public class JoinColumnBuilder extends BaseModelBuilder implements JoinColumnConfigurationBuilder {

    private final JoinColumn joinColumn;

    JoinColumnBuilder(JoinColumn joinColumn) {
        this.joinColumn = joinColumn;
    }

    @Override
    public <S> JoinColumnConfigurationBuilder referencing(Expression<S, ?> propertyExpression) {
        var columnName = expressionParser.parse(propertyExpression).property();
        this.joinColumn.setReferencedColumnName(columnName);
        return this;
    }

    @Override
    public JoinColumnConfigurationBuilder referencing(String referencedColumnName) {
        this.joinColumn.setReferencedColumnName(referencedColumnName);
        return this;
    }

    @Override
    public JoinColumnConfigurationBuilder withLength(int length) {
        //TODO - remove this length param
        throw new UnsupportedOperationException("Will deal with this later");
    }

    @Override
    public JoinColumnConfigurationBuilder isRequired() {
        this.joinColumn.setNullable(false);
        return this;
    }

    @Override
    public JoinColumnConfigurationBuilder isRequired(boolean value) {
        this.joinColumn.setNullable(value);
        return this;
    }

    @Override
    public JoinColumnConfigurationBuilder isUnique() {
        this.joinColumn.setUnique(true);
        return this;
    }

    @Override
    public JoinColumnConfigurationBuilder isUnique(boolean value) {
        this.joinColumn.setUnique(value);
        return this;
    }
}
