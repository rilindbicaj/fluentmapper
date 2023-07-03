package com.bicicom.fluentmapper.model.builder;

/**
 * Configures a many-to-one relationship.
 *
 * @param <S> the owning entity
 * @param <T> the target, related entity
 */
public interface ManyToOneConfigurationBuilder<S, T> {

    /**
     * Specifies the foreign key in S realizing this relationship.
     *
     * @param foreignKey the foreign key column name, present in the source entity's table
     * @return the builder for chaining further calls
     */
    ManyToOneConfigurationBuilder<S, T> hasForeignKey(String foreignKey);

}

