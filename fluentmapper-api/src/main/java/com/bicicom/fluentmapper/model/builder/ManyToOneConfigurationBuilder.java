package com.bicicom.fluentmapper.model.builder;

/**
 * Configures a JPA {@code many-to-one} relationship. Currently, this relationship can only be marked as the owning
 * side of a {@code one-to-many} relationship, following the recommended approach of JPA 2.2 specification regarding
 * {@code one-to-many} relationships (section 2.9).
 *
 * @param <S> the source, owning entity of the relationship
 * @param <T> the target, non-owning entity of the relationship
 */
public interface ManyToOneConfigurationBuilder<S, T> {

    /**
     * Specifies the foreign key in {@code <S>} which references the primary key in {@code <T>}.
     *
     * @param foreignKey the foreign key column name, present in {@code <S>}.
     *
     * @return the same builder for further chaining
     */
    ManyToOneConfigurationBuilder<S, T> hasForeignKey(String foreignKey);
}

