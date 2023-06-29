package com.bicicom.fluentmapper.provider.core;

import com.bicicom.fluentmapper.core.FluentMapper;
import com.bicicom.fluentmapper.core.MapperConfigurationBuilder;
import com.bicicom.fluentmapper.core.config.MapperConfiguration;
import com.bicicom.fluentmapper.provider.core.config.InternalMapperConfigurationBuilder;

import java.util.function.Consumer;

/**
 * Handles creation of FluentMapper instances. Also possesses a hilarious name.
 * At least to me.
 */

public class FluentFactory {

    public FluentMapper createConfigured(Consumer<MapperConfigurationBuilder> configApplier) {
        InternalMapperConfigurationBuilder configurationBuilder = InternalMapperConfigurationBuilder.create();
        configApplier.accept(configurationBuilder);

        MapperConfiguration mapperConfiguration = configurationBuilder.build();

        return new DefaultFluentMapper(mapperConfiguration);
    }

}
