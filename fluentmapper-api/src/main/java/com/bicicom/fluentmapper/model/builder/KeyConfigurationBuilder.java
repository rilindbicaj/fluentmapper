package com.bicicom.fluentmapper.model.builder;

import java.util.function.Consumer;

/**
 * Configures the primary key of an entity.
 *
 * @param <S> the source entity whose key is being configured
 * @param <P> the type of the property bound to this key
 */
public interface KeyConfigurationBuilder<S, P> {

    KeyConfigurationBuilder<S, P> toColumn(String column, Consumer<ColumnConfigurationBuilder> columnConfigurationConsumer);

}
