package com.bicicom.fluentmapper.model.builder;

import com.bicicom.fluentmapper.expression.Expression;

/**
 * Configures a JPA One-to-One relationship between entities S and T.
 *
 * @param <S> the source entity being configured
 * @param <T> the target entity of the one-to-one relationship
 */
public interface OneToOneConfigurationBuilder<S, T> {

    /**
     * Specifies the property which maps this relationship.
     *
     * @param propertyExpression the expression accessing the property mapping the relationship
     * @return the builder
     */
    OneToOneConfigurationBuilder<S, T> mappedBy(Expression<T, S> propertyExpression);

    /**
     * Marks the relationship as non-owned and mapped by the referenced entity.
     *
     * @return the same builder for chaining calls
     */
    OneToOneConfigurationBuilder<S, T> isMapped();

    /**
     * Specifies the foreign key of this relationship, present in the source model.
     *
     * @param foreignKeyProperty
     * @return a builder for configuring the foreign key column
     */
    JoinColumnConfigurationBuilder hasForeignKey(String foreignKeyProperty);

}
