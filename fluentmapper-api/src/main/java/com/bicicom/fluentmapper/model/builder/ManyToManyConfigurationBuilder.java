package com.bicicom.fluentmapper.model.builder;

import com.bicicom.fluentmapper.expression.Expression;

import java.util.Collection;

public interface ManyToManyConfigurationBuilder<S, T> {

    /**
     * Specifies the table on which this many-to-many relationship is realized.
     *
     * @param tableName the name of the table realizing this relationship
     * @return a builder for configuring the table mappings
     */
    JoinTableConfigurationBuilder joinOnTable(String tableName);

    /**
     * Specifies the property mapping this relationship if not on the owning side.
     *
     * @param propertyExpression the expression specifying the property which maps the relationship
     * @return the same builder for call chains
     */

    ManyToManyConfigurationBuilder<S, T> mappedBy(Expression<T, Collection<S>> propertyExpression);

}
