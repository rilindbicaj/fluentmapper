package com.bicicom.fluentmapper.model.builder;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.expression.Expression;

import java.util.Collection;

/**
 * Configures the JPA mappings of a domain entity {@code <S>}. This builder represents the root of all builders, and
 * serves as the entry point from which they can be created. All mapping configurations must start with the base
 * {@link ModelBuilder} provided via {@link EntityMapper}.
 *
 * @param <S> the source entity, for which this builder will create subsequent builders for
 */
public interface ModelBuilder<S> {

    /**
     * Specifies the primary key of source entity {@code <S>}.
     *
     * @param expression the expression specifying the primary key property
     * @param <T>        the target type of the primary key property
     *
     * @return a {@link KeyConfigurationBuilder} for configuring the primary key mapping
     */
    <T> KeyConfigurationBuilder<S, T> hasKey(Expression<S, T> expression);

    /**
     * Initiates a mapping configuration for the specified property.
     *
     * @param expression the expression specifying the property to initiate mapping configuration for
     *
     * @return a {@link PropertyConfigurationBuilder} to specify the property's mappings
     */
    PropertyConfigurationBuilder property(Expression<S, ?> expression);

    /**
     * Specifies the table where the source entity {@code <S>} is contained.
     *
     * @param tableName the name of the table
     *
     * @return a {@link TableConfigurationBuilder} to configure the mappings of the table
     */
    TableConfigurationBuilder toTable(String tableName);

    /**
     * Initiates a relationship mapping configuration chain, by specifying what "one" entity {@code <S>} has. This
     * can result in a {@code many-to-one} or {@code one-to-one} relationship configuration.
     *
     * @param expression the expression specifying the property representing the "one" entity which {@code <S>} has.
     * @param <T>        the target entity, of which {@code <S>} has one of.
     *
     * @return a {@link OneRelationshipConfigurationBuilder} to specify the multiplicity of the relationship.
     */
    <T> OneRelationshipConfigurationBuilder<T, S> hasOne(Expression<S, T> expression);

    /**
     * Initiates a relationship mapping configuration chain, by specifying what "many" of an entity {@code <S>} has.
     * This can result in a {@code one-to-many} or {@code many-to-many} relationship configuration.
     *
     * @param expression the expression specifying the property representing the "many" of an entity which {@code <S>}
     *                   has. The specified property is expected to be a {@link Collection}.
     * @param <T>        the target entity, of which {@code <S>} has many of.
     *
     * @return a {@link ManyRelationshipConfigurationBuilder} to specify the multiplicity of the relationship.
     */
    <T> ManyRelationshipConfigurationBuilder<T, S> hasMany(Expression<S, Collection<T>> expression);

}
