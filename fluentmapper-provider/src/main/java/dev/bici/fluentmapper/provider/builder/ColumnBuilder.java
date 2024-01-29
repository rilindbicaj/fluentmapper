package dev.bici.fluentmapper.provider.builder;

import dev.bici.fluentmapper.model.builder.ColumnConfigurationBuilder;
import dev.bici.fluentmapper.provider.model.Column;

public class ColumnBuilder implements ColumnConfigurationBuilder {

    private final Column column;

    public ColumnBuilder(Column column) {
        this.column = column;
    }

    @Override
    public ColumnConfigurationBuilder withLength(int length) {
        column.setLength(length);
        return this;
    }

    @Override
    public ColumnConfigurationBuilder isRequired() {
        column.setNullable(false);
        return this;
    }

    @Override
    public ColumnConfigurationBuilder isRequired(boolean value) {
        column.setNullable(value);
        return this;
    }

    @Override
    public ColumnConfigurationBuilder isUnique() {
        column.setUnique(true);
        return this;
    }

    @Override
    public ColumnConfigurationBuilder isUnique(boolean value) {
        column.setUnique(value);
        return this;
    }
}
