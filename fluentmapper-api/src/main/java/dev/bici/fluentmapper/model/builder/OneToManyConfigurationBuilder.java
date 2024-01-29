package dev.bici.fluentmapper.model.builder;

import dev.bici.fluentmapper.expression.Expression;

/**
 * Configures a JPA {@code one-to-many} relationship.
 *
 * @param <S> the source entity, having many of {@code <T>}
 * @param <T> the target entity, of which {@code <S>} has many of
 */
public interface OneToManyConfigurationBuilder<S, T> {

    /**
     * Specifies the property mapping this relationship, if {@code <T>} is not on the owning side. This effectively
     * marks {@code <S>} as the owning side of the relationship.
     *
     * @param propertyExpression the expression specifying the property in {@code <S>} which maps the relationship.
     * @return the same builder for further chaining
     */
    OneToManyConfigurationBuilder<S, T> mappedBy(Expression<T, S> propertyExpression);

}
