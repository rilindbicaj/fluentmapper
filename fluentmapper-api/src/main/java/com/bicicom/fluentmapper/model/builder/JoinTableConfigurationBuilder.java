package com.bicicom.fluentmapper.model.builder;

/**
 * Configures a JPA {@code JoinTable} mapping.
 */
public interface JoinTableConfigurationBuilder {

    /**
     * Specifies the foreign key referencing the owning entity's primary key in the {@code JoinTable}, as well as the
     * primary key's name.
     *
     * @param foreignKey           the foreign key column's name, present in the {@code JoinTable}
     * @param referencedPrimaryKey the primary key column's name, being referenced by this foreign key
     * @return the same builder for further chaining
     */
    JoinTableConfigurationBuilder withForeignKey(String foreignKey, String referencedPrimaryKey);

    /**
     * Specifies the foreign key referencing the owning entity's primary key in the {@code JoinTable}. The owning
     * entity's primary key name is assumed to be the same as the foreign key's.
     *
     * @param foreignKey the foreign key column's name, present in the {@code JoinTable}
     * @return the same builder for further chaining
     */
    JoinTableConfigurationBuilder withForeignKey(String foreignKey);

    /**
     * Specifies the foreign key referencing the non-owning entity's primary key in the {@code JoinTable}, as well as the
     * primary key's name.
     *
     * @param foreignKey   the foreign key column's name, present in the non-owning entity
     * @param joinTableKey the primary key column in the {@code oinTable} this foreign key references
     * @return the same builder for further chaining
     */
    JoinTableConfigurationBuilder withInverseForeignKey(String foreignKey, String joinTableKey);

    /**
     * Specifies the foreign key referencing the non-owning entity's primary key in the {@code JoinTable}. The non-owning
     * entity's primary key name is assumed to be the same as the foreign key's.
     *
     * @param foreignKey the foreign key column's name, present in the non-owning entity
     * @return the same builder for further chaining
     */
    JoinTableConfigurationBuilder withInverseForeignKey(String foreignKey);

}
