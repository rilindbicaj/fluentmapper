package com.bicicom.fluentmapper.core;


/**
 * A builder for creating the configuration of FluentMapper.
 */
public interface MapperConfigurationBuilder {
    MapperConfigurationBuilder withMappingsPackage(String mappingsPackage);

    MapperConfigurationBuilder withMappingsPath(String mappingsPath);

    MapperConfigurationBuilder exports();

    MapperConfigurationBuilder exportsTo(String... paths);
}
