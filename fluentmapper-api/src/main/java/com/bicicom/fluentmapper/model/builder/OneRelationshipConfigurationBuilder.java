package com.bicicom.fluentmapper.model.builder;

import com.bicicom.fluentmapper.expression.Expression;

import java.util.Collection;

/**
 * Intermediary relationship builder for One-to relationships. Produces One-to-One builders
 * and One-to-Many builders.
 *
 * @param <T> the entity of which <code>S</code> has one of
 * @param <S> the entity having one of <code>T</code>
 */

public interface OneRelationshipConfigurationBuilder<T, S> {

    OneToOneConfigurationBuilder<S, T> withOne(Expression<T, S> expression);

    OneToManyConfigurationBuilder<S, T> withMany(Expression<T, Collection<S>> expression);

}
