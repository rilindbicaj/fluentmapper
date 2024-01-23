package com.bicicom.fluentmapper.model.builder;

import java.util.function.Consumer;

/**
 * Configures a JPA {@code Id} mapping, or in general terms, a primary key.
 *
 * @param <S> the source entity whose {@code Id} mapping is being configured
 * @param <T> the type of the property mapping this {@code Id}
 */
public interface KeyConfigurationBuilder<S, T> {

    /**
     * Specifies the name of the column this primary key is contained in.
     *
     * @param columnName the name of the column
     * @return the same builder for further chaining
     */
    KeyConfigurationBuilder<S, T> toColumn(String columnName);

    /**
     * Specifies the name of the column this primary key is contained in, as well as provides the option to
     * configure the same column.
     *
     * @param columnName                  the name of the column
     * @param columnConfigurationConsumer a {@link Consumer} which accepts a {@link ColumnConfigurationBuilder} and
     *                                    configures the column as per its instructions
     * @return the same builder for further chaining
     */
    KeyConfigurationBuilder<S, T> toColumn(String columnName, Consumer<ColumnConfigurationBuilder> columnConfigurationConsumer);

}
