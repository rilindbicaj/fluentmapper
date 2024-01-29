package dev.bici.fluentmapper.model.builder;

import dev.bici.fluentmapper.expression.Expression;

/**
 * Configures a JPA {@code JoinColumn} mapping.
 *
 * @param <S> the source entity, containing the {@code JoinColumn}
 * @param <T> the target entity, holding the key which this {@code JoinColumn} references
 */
public interface JoinColumnConfigurationBuilder<S, T> extends ColumnConfigurationBuilder {

    /**
     * Specifies the column this {@code JoinColumn} references in the target entity {@code <T>}.
     *
     * @param propertyExpression the expression specifying the property in {@code <T>}
     * @return the same builder for further chaining
     */
    JoinColumnConfigurationBuilder<S, T> referencing(Expression<S, ?> propertyExpression);

    /**
     * Specifies the column this {@code JoinColumn} references in the target entity {@code <T>}.
     *
     * @param referencedColumnName the name of the column in {@code <T>}.
     * @return the same builder for further chaining
     */
    JoinColumnConfigurationBuilder<S, T> referencing(String referencedColumnName);

    /**
     * {@inheritDoc}
     */
    JoinColumnConfigurationBuilder<S, T> withLength(int length);

    /**
     * {@inheritDoc}
     */
    JoinColumnConfigurationBuilder<S, T> isRequired();

    /**
     * {@inheritDoc}
     */
    JoinColumnConfigurationBuilder<S, T> isRequired(boolean value);

    /**
     * {@inheritDoc}
     */
    JoinColumnConfigurationBuilder<S, T> isUnique();

    /**
     * {@inheritDoc}
     */
    JoinColumnConfigurationBuilder<S, T> isUnique(boolean value);

}
