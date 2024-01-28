package com.bicicom.fluentmapper.model.builder;

import com.bicicom.fluentmapper.expression.Expression;

import java.util.Collection;

/**
 * Builder which acts as an intermediate step for configuring a {@code one-to} relationship. Provides
 * builders for both {@code one-to-one} and {@code many-to-one} mappings.
 * <p>
 * Due to the way JPA works, instead of a {@code one-to-many} builder, a {@code many-to-one} builder is returned
 * instead. This is due to verbal differences between the builder API and that of the JPAs - an entity has one of
 * an entity, expressed via builders via the {@link ModelBuilder#hasOne(Expression)} and
 * {@link OneRelationshipConfigurationBuilder#withMany(Expression)}. However, in JPA this is expressed via the
 * {@code ManyToOne} mapping, hence the "opposite" builder being returned.
 *
 * @param <T> the target entity of the relationship - the "one" of which {@code <S>} has.
 * @param <S> the source entity of the relationship, having one of {@code <S>}.
 */
public interface OneRelationshipConfigurationBuilder<T, S> {

    /**
     * Specifies the property in target entity {@code <T>}, also having on of {@code <S>}, marking this as a {@code
     * one-to-one} relationship. The property represents the other side of this relationship, marking it as a
     * {@code bidirectional} one.
     *
     * @param expression the expression specifying the property in the target entity {@code <T>} which realizes the
     *                   other size of this {@code one-to-one} relationship.
     *
     * @return a {@link OneToOneConfigurationBuilder} to further configure the relationship
     */
    OneToOneConfigurationBuilder<S, T> withOne(Expression<T, S> expression);

    /**
     * Marks this relationship as a {@code one-to-one} relationship. By omitting a property from {@code <S>}, the
     * relationship is configured to be {@code unidirectional}, with the owner being {@code <T>}.
     *
     * @return a {@link OneToOneConfigurationBuilder} to further configure the relationship
     */
    OneToOneConfigurationBuilder<S, T> withOne();

    /**
     * Specifies the property in target entity {@code <T>}, having many of {@code <S>}, marking this as a {@code
     * many-to-one} relationship. The property represents the other side of this relationship, marking it as a
     * {@code bidirectional} one. It also has to be of type {@link Collection}.
     *
     * @param expression the expression specifying the property in the target entity {@code <T>} which realizes the
     *                   other size of this {@code many-to-one} relationship.
     *
     * @return a {@link ManyToOneConfigurationBuilder} to further configure the relationship
     */
    ManyToOneConfigurationBuilder<S, T> withMany(Expression<T, Collection<S>> expression);

    /**
     * Marks this relationship as a {@code many-to-one} relationship. By omitting a property from {@code <S>}, the
     * relationship is configured to be {@code unidirectional}, with the owner being {@code <T>}.
     *
     * @return a {@link ManyToOneConfigurationBuilder} to further configure the relationship
     */
    ManyToOneConfigurationBuilder<S, T> withMany();
}
