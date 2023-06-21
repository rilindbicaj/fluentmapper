package com.bicicom.fluentmapper.model.builder;

public interface JoinTableConfigurationBuilder {

    JoinTableConfigurationBuilder withColumns(String... columns);

    JoinTableConfigurationBuilder andInverseColumns(String... inverseColumns);

}
