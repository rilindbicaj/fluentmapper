package com.bicicom.fluentmapper.model.builder;

import com.bicicom.fluentmapper.expression.Expression;

import java.util.Collection;

/**
 * Configures a JPA {@code many-to-many} relationship. This type of relationship is malleable when it comes to
 * determining the owning, and non owning, side of it. Therefore, neither {@code <S>} nor {@code <T>} are, by default,
 * owner or non-owner of it. These have to be explicitly specified.
 *
 * @param <S> the source entity, for which the relationship is being configured
 * @param <T> the target entity, forming the other side of the relationship
 */
public interface ManyToManyConfigurationBuilder<S, T> {

    /**
     * Specifies the junction table on which this {@code many-to-many} relationship is realized. Calling this method
     * effectively marks {@code <S>} as the owning side of the relationship.
     *
     * @param tableName the name of the junction table realizing this relationship
     *
     * @return a {@link JoinTableConfigurationBuilder} to further configure the table
     */
    JoinTableConfigurationBuilder joinOnTable(String tableName);

    /**
     * Specifies the property mapping this relationship, if {@code <T>} is not on the owning side. This effectively
     * marks {@code <S>} as the owning side of the relationship.
     *
     * @param propertyExpression the expression specifying the property in {@code <S>} which maps the relationship.
     *
     * @return the same builder for further chaining
     */
    ManyToManyConfigurationBuilder<S, T> mappedBy(Expression<T, Collection<S>> propertyExpression);


    /**
     * Marks this relationship as mapped by the associated property in {@code <S>} which forms the other side of the
     * relationship, effectively marking {@code <T>} as the non-owning side of it. Calling this method is equivalent to
     * calling {@link ManyToManyConfigurationBuilder#mappedBy(Expression)} with an expression pointing to that
     * associated property in {@code <S>}.
     *
     * @return the same builder for further chaining
     */
    ManyToManyConfigurationBuilder<S, T> isMapped();
}
