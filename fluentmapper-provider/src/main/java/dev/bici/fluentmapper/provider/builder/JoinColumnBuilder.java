package dev.bici.fluentmapper.provider.builder;

import dev.bici.fluentmapper.expression.Expression;
import dev.bici.fluentmapper.model.builder.JoinColumnConfigurationBuilder;
import dev.bici.fluentmapper.provider.model.JoinColumn;

public class JoinColumnBuilder<S, T> extends BaseModelBuilder implements JoinColumnConfigurationBuilder<S, T> {

    private final JoinColumn joinColumn;

    JoinColumnBuilder(JoinColumn joinColumn) {
        this.joinColumn = joinColumn;
    }

    @Override
    public JoinColumnConfigurationBuilder<S, T> referencing(Expression<S, ?> propertyExpression) {
        var columnName = expressionParser.parse(propertyExpression).property();
        this.joinColumn.setReferencedColumnName(columnName);
        return this;
    }

    @Override
    public JoinColumnConfigurationBuilder<S, T> referencing(String referencedColumnName) {
        this.joinColumn.setReferencedColumnName(referencedColumnName);
        return this;
    }

    @Override
    public JoinColumnConfigurationBuilder<S, T> withLength(int length) {
        // TODO - remove this length param from the interface
        throw new UnsupportedOperationException();
    }

    @Override
    public JoinColumnConfigurationBuilder<S, T> isRequired() {
        this.joinColumn.setNullable(false);
        return this;
    }

    @Override
    public JoinColumnConfigurationBuilder<S, T> isRequired(boolean value) {
        this.joinColumn.setNullable(value);
        return this;
    }

    @Override
    public JoinColumnConfigurationBuilder<S, T> isUnique() {
        this.joinColumn.setUnique(true);
        return this;
    }

    @Override
    public JoinColumnConfigurationBuilder<S, T> isUnique(boolean value) {
        this.joinColumn.setUnique(value);
        return this;
    }
}
