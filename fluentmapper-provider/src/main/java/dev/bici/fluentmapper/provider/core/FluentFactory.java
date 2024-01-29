package dev.bici.fluentmapper.provider.core;

import dev.bici.fluentmapper.core.FluentMapper;
import dev.bici.fluentmapper.core.MapperConfigurationBuilder;
import dev.bici.fluentmapper.core.config.MapperConfiguration;
import dev.bici.fluentmapper.provider.core.config.InternalMapperConfigurationBuilder;

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
     * @return a configured, immutable instance of {@link FluentMapper}
     */
    public static FluentMapper createConfigured(Consumer<MapperConfigurationBuilder> configurationBuilderConsumer) {
        InternalMapperConfigurationBuilder configurationBuilder = InternalMapperConfigurationBuilder.create();
        configurationBuilderConsumer.accept(configurationBuilder);

        MapperConfiguration mapperConfiguration = configurationBuilder.build();

        return new DefaultFluentMapper(mapperConfiguration);
    }

}
