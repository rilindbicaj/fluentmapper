package com.bicicom.fluentmapper.model.builder;

import com.bicicom.fluentmapper.expression.Expression;

import java.util.Collection;

/**
 * Intermediary relationship builder for One-to relationships. Produces One-to-One builders
 * and Many-to-One builders.
 * <p>
 * Because of the logic behind one-to-many and many-to-one being inverted in JPA terms, the
 * API is rather weird, and deviates from the EFCore way.
 *
 * @param <T> the entity of which <code>S</code> has one of
 * @param <S> the entity having one of <code>T</code>
 */

public interface OneRelationshipConfigurationBuilder<T, S> {

    OneToOneConfigurationBuilder<S, T> withOne(Expression<T, S> expression);

    OneToOneConfigurationBuilder<S, T> withOne();

    ManyToOneConfigurationBuilder<S, T> withMany(Expression<T, Collection<S>> expression);

    ManyToOneConfigurationBuilder<S, T> withMany();

}
