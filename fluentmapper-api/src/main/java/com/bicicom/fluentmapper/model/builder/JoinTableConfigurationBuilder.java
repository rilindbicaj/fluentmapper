package com.bicicom.fluentmapper.model.builder;

public interface JoinTableConfigurationBuilder {

    /**
     * Specifies the foreign key of the configured entity, as well as that of the primary key column
     * it references in the join table.
     *
     * @param foreignKey   the foreign key column's name
     * @param joinTableKey the primary key column in the join table this foreign key references
     * @return the same builder for chaining calls
     */
    JoinTableConfigurationBuilder withForeignKey(String foreignKey, String joinTableKey);

    /**
     * Specifies the foreign key of the configured entity which references the join table. This
     * approach assumes the entity's foreign key naming is the same as the primary key in the
     * join table.
     *
     * @param foreignKey the foreign key column's name
     * @return the same builder for chaining calls
     */
    JoinTableConfigurationBuilder withForeignKey(String foreignKey);

    /**
     * Specifies the foreign key of the related entity in this relationship, as well as that of the
     * primary key column it references in the join table.
     *
     * @param foreignKey   the foreign key column's name, present in the related entity
     * @param joinTableKey the primary key column in the join table this foreign key references
     * @return the same builder for chaining calls
     */
    JoinTableConfigurationBuilder withInverseForeignKey(String foreignKey, String joinTableKey);

    /**
     * Specifies the foreign key of the related entity in this relationship, which references the join table.
     * This approach assumes the entity's foreign key naming is the same as the primary key in the join table.
     *
     * @param foreignKey the foreign key column's name, present in the related entity
     * @return the same builder for chaining calls
     */
    JoinTableConfigurationBuilder withInverseForeignKey(String foreignKey);

}
