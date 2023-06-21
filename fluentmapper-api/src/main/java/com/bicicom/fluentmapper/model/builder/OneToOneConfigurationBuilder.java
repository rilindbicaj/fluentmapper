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
    OneToOneConfigurationBuilder<S, T> mappedBy(Expression<S, ?> propertyExpression);

    /**
     * Specifies cascade handling for this relationship.
     *
     * @param cascadeType the cascade type
     * @return the builder
     */
    OneToOneConfigurationBuilder<S, T> cascade(CascadeType cascadeType);

}
