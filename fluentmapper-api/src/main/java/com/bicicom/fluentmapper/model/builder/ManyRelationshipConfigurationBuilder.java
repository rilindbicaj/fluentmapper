package com.bicicom.fluentmapper.model.builder;

import com.bicicom.fluentmapper.expression.Expression;

import java.util.Collection;

/**
 * Builder which acts as an intermediate step for configuring a {@code many-to} relationship. Provides
 * builders for both {@code one-to-many} and {@code many-to-many} mappings.
 * <p>
 * Due to the way JPA works, instead of a {@code many-to-one} builder, a {@code one-to-many} builder is returned instead.
 * This is due to verbal differences between the builder API and that of the JPAs - an entity has many of one entity,
 * expressed via builders via the {@link ModelBuilder#hasMany(Expression)} and
 * {@link ManyRelationshipConfigurationBuilder#withOne(Expression)}. However, in JPA this is expressed via the
 * {@code OneToMany} mapping, hence the "opposite" builder being returned.
 *
 * @param <T> the target entity of the relationship - the "many" of which {@code <S>} has.
 * @param <S> the source entity of the relationship, having many of {@code <T>}
 */
public interface ManyRelationshipConfigurationBuilder<T, S> {

    /**
     * Specifies the property in target entity {@code <T>} which maps the non-owner side of the bidirectional
     * relationship, representing the "one" {@code <T>} has of {@code <S>}.
     *
     * @param propertyExpression the expression specifying the property
     *
     * @return a {@link OneToManyConfigurationBuilder} to further configure the relationship
     */
    OneToManyConfigurationBuilder<S, T> withOne(Expression<T, S> propertyExpression);

    /**
     * Specifies the property in target entity {@code <T>} which maps the non-owning side of the bidirectional
     * relationship, representing the "many" {@code <T>} has of {@code <S>}. The target property needs to be a
     * {@link Collection} of {@code <S>}.
     *
     * @param propertyExpression the expression specifying the property
     *
     * @return a {@link ManyToManyConfigurationBuilder} to further configure the relationship
     */
    ManyToManyConfigurationBuilder<S, T> withMany(Expression<T, Collection<S>> propertyExpression);

}
