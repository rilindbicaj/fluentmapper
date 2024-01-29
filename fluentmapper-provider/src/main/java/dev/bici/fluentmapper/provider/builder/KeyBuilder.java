package dev.bici.fluentmapper.provider.builder;


import dev.bici.fluentmapper.model.builder.ColumnConfigurationBuilder;
import dev.bici.fluentmapper.model.builder.KeyConfigurationBuilder;
import dev.bici.fluentmapper.provider.model.Column;
import dev.bici.fluentmapper.provider.model.Id;

import java.util.function.Consumer;

public class KeyBuilder<S, T> extends BaseModelBuilder implements KeyConfigurationBuilder<S, T> {

    private final Id key;

    public KeyBuilder(Id key) {
        this.key = key;
    }

    @Override
    public KeyConfigurationBuilder<S, T> toColumn(String columnName) {
        Column keyColumn = new Column();
        keyColumn.setName(columnName);

        key.setColumn(keyColumn);

        return this;
    }

    @Override
    public KeyConfigurationBuilder<S, T> toColumn(String columnName, Consumer<ColumnConfigurationBuilder> columnConfigurationConsumer) {
        Column keyColumn = new Column();
        keyColumn.setName(columnName);

        ColumnBuilder columnBuilder = new ColumnBuilder(keyColumn);
        columnConfigurationConsumer.accept(columnBuilder);

        key.setColumn(keyColumn);

        return this;
    }
}
