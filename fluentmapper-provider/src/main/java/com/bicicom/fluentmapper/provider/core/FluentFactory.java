package com.bicicom.fluentmapper.provider.core;

import com.bicicom.fluentmapper.core.FluentMapper;
import com.bicicom.fluentmapper.core.MapperConfigurationBuilder;
import com.bicicom.fluentmapper.core.config.MapperConfiguration;
import com.bicicom.fluentmapper.provider.core.config.InternalMapperConfigurationBuilder;

import java.util.function.Consumer;

/**
 * Provides methods for creating instances of {@link FluentMapper}. Also possesses a brilliant name.
 */
public class FluentFactory {

    private FluentFactory() {
        throw new UnsupportedOperationException();
    }

    /**
     * Creates a configured instance of {@link FluentMapper} by applying the provided {@link Consumer} to create the
     * configuration.
     *
     * @param configurationBuilderConsumer a {@link Consumer} accepting a {@link MapperConfigurationBuilder} used to
     *                                     apply the desired configuration to the {@link FluentMapper} instance created.
     *
     * @return a configured, immutable instance of {@link FluentMapper}
     */
    public static FluentMapper createConfigured(Consumer<MapperConfigurationBuilder> configurationBuilderConsumer) {
        InternalMapperConfigurationBuilder configurationBuilder = InternalMapperConfigurationBuilder.create();
        configurationBuilderConsumer.accept(configurationBuilder);

        MapperConfiguration mapperConfiguration = configurationBuilder.build();

        return new DefaultFluentMapper(mapperConfiguration);
    }

}
