package com.bicicom.fluentmapper.model.builder;

public interface PropertyConfigurationBuilder {

    ColumnConfigurationBuilder toColumn(String column);

    PropertyConfigurationBuilder isOptional();

    PropertyConfigurationBuilder isOptional(boolean value);

    PropertyConfigurationBuilder hasFetchType(FetchType fetchType);

}
