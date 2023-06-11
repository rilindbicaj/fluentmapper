package com.bicicom.fluentmapper.core;


/**
 * A builder for creating the configuration of FluentMapper.
 */
public interface MapperConfigurationBuilder {
    MapperConfigurationBuilder withMappingsPackage(String mappingsPackage);

    MapperConfigurationBuilder exports();

    MapperConfigurationBuilder exports(String path);
}
