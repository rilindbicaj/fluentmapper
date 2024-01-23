package com.bicicom.fluentmapper.model.builder;

/**
 * Configures the mappings of a JPA column.
 */
public interface ColumnConfigurationBuilder {
    /**
     * Sets the {@code length} of the column being configured.
     *
     * @param length the length of the column
     *
     * @return the same builder for further chaining
     */
    ColumnConfigurationBuilder withLength(int length);

    /**
     * Marks the column as {@code required}.
     *
     * @return the same builder for further chaining
     */
    ColumnConfigurationBuilder isRequired();

    /**
     * Sets the {@code required} value of the columns being configured.
     *
     * @param value the value to be set
     *
     * @return the same builder for further chaining
     */
    ColumnConfigurationBuilder isRequired(boolean value);

    /**
     * Marks the column as {@code unique}.
     *
     * @return the same builder for further chaining
     */
    ColumnConfigurationBuilder isUnique();

    /**
     * Sets the {@code unique} value of the column.
     *
     * @param value the boolean value to be set
     *
     * @return the same builder for further chaining
     */
    ColumnConfigurationBuilder isUnique(boolean value);
}
