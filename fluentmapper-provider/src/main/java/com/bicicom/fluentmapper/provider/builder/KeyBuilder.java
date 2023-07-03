package com.bicicom.fluentmapper.provider.builder;


import com.bicicom.fluentmapper.model.builder.ColumnConfigurationBuilder;
import com.bicicom.fluentmapper.model.builder.KeyConfigurationBuilder;
import com.bicicom.fluentmapper.provider.model.mutable.Column;
import com.bicicom.fluentmapper.provider.model.mutable.Key;

import java.util.function.Consumer;

public class KeyBuilder<S, T> extends BaseModelBuilder implements KeyConfigurationBuilder<S, T> {

    private final Key key;

    public KeyBuilder(Key key) {
        this.key = key;
    }

    @Override
    public KeyConfigurationBuilder<S, T> toColumn(String columnName) {
        Column keyColumn = new Column(columnName);
        key.setColumn(keyColumn);

        return this;
    }

    @Override
    public KeyConfigurationBuilder<S, T> toColumn(String columnName, Consumer<ColumnConfigurationBuilder> columnConfigurationConsumer) {
        Column keyColumn = new Column(columnName);
        ColumnBuilder columnBuilder = new ColumnBuilder(keyColumn);

        columnConfigurationConsumer.accept(columnBuilder);
        key.setColumn(keyColumn);

        return this;
    }
}
