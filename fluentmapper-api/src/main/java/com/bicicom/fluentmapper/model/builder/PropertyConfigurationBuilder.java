package com.bicicom.fluentmapper.model.builder;

public interface PropertyConfigurationBuilder {

    ColumnConfigurationBuilder toColumn(String columnName);

    PropertyConfigurationBuilder isOptional();

    PropertyConfigurationBuilder isOptional(boolean value);

}
