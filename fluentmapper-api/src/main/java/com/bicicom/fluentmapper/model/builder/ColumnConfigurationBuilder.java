package com.bicicom.fluentmapper.model.builder;

public interface ColumnConfigurationBuilder {
    ColumnConfigurationBuilder withLength(int length);

    ColumnConfigurationBuilder isRequired();

    ColumnConfigurationBuilder isRequired(boolean value);

    ColumnConfigurationBuilder isUnique();

    ColumnConfigurationBuilder isUnique(boolean value);
}
