package com.bicicom.fluentmapper.core;

import java.util.ServiceLoader;
import java.util.function.Consumer;

public interface FluentMapper {

    static FluentMapper createConfigured(Consumer<MapperConfigurationBuilder> configApplier) {
        return ServiceLoader.load(FluentMapperProvider.class)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Could not find impl for " + FluentMapperProvider.class))
                .createConfigured(configApplier);
    }

    void execute();

    String getMappings();

}
