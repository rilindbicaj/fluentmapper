package dev.bici.fluentmapper.model.builder;

import dev.bici.fluentmapper.expression.Expression;

/**
 * Configures a JPA {@code one-to-one} relationship.
 *
 * @param <S> the source entity, having one of {@code <T>}
 * @param <T> the target entity, of which {@code <S>} has one of.
 */
public interface OneToOneConfigurationBuilder<S, T> {

    /**
     * Specifies the property mapping this relationship, if {@code <T>} is not on the owning side. This effectively
     * marks {@code <S>} as the owning side of the relationship.
     *
     * @param propertyExpression the expression specifying the property in {@code <S>} which maps the relationship.
     * @return the same builder for further chaining
     */
    OneToOneConfigurationBuilder<S, T> mappedBy(Expression<T, S> propertyExpression);

    /**
     * Marks this relationship as mapped by the associated property in {@code <S>} which forms the other side of the
     * relationship, effectively marking {@code <T>} as the non-owning side of it. Calling this method is equivalent to
     * calling {@link OneToOneConfigurationBuilder#mappedBy(Expression)} with an expression pointing to that
     * associated property in {@code <S>}.
     *
     * @return the same builder for further chaining
     */
    OneToOneConfigurationBuilder<S, T> isMapped();

    /**
     * Specifies the foreign key of this relationship, present in the source entity {@code <S>}.
     *
     * @param foreignKeyProperty the name of the foreign key
     * @return a {@link JoinColumnConfigurationBuilder} to configure the mappings of the foreign key column
     */
    JoinColumnConfigurationBuilder<S, T> hasForeignKey(String foreignKeyProperty);

}
