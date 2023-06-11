package com.bicicom.fluentmapper.model.builder;

public interface TableConfigurationBuilder {
    TableConfigurationBuilder withSchema(String schema);

    TableConfigurationBuilder withCatalog(String catalog);
}
