package dev.bici.fluentmapper.model.builder;

/**
 * Configures a JPA {@code table} mappings.
 */
public interface TableConfigurationBuilder {

    /**
     * Specifies the schema of the table.
     *
     * @param schema the name of the schema
     * @return the same builder for further chaining
     */
    TableConfigurationBuilder withSchema(String schema);

    /**
     * Specifies the catalog of the table.
     *
     * @param catalog the name of the catalog
     * @return the same builder for further chaining
     */
    TableConfigurationBuilder withCatalog(String catalog);
}
