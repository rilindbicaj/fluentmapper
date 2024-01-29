package dev.bici.fluentmapper.model.builder;

/**
 * Configures a JPA {@code Basic} mapping.
 */
public interface PropertyConfigurationBuilder {

    /**
     * Specifies the column this property is mapped to in its respective table.
     *
     * @param columnName the name of the column
     * @return a {@link ColumnConfigurationBuilder} to configure the mappings of the column
     */
    ColumnConfigurationBuilder toColumn(String columnName);

    /**
     * Marks this property as {@code optional}.
     *
     * @return the same builder for further chaining
     */
    PropertyConfigurationBuilder isOptional();

    /**
     * Specifies the {@code optional} value of the column being configured.
     *
     * @param value the value to be set
     * @return the same builder for further chaining
     */
    PropertyConfigurationBuilder isOptional(boolean value);

}
