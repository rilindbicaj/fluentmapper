package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.model.builder.TableConfigurationBuilder;
import com.bicicom.fluentmapper.provider.model.Table;

public class TableBuilder implements TableConfigurationBuilder {

    private final Table table;

    public TableBuilder(Table table) {
        this.table = table;
    }

    @Override
    public TableConfigurationBuilder withSchema(String schema) {
        table.setSchema(schema);
        return this;
    }

    @Override
    public TableConfigurationBuilder withCatalog(String catalog) {
        table.setCatalog(catalog);
        return this;
    }
}
