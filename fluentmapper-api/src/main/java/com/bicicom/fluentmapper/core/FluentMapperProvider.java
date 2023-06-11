package com.bicicom.fluentmapper.core;

import java.util.function.Consumer;

public interface FluentMapperProvider {

    FluentMapper createConfigured(Consumer<MapperConfigurationBuilder> configApplier);

}
