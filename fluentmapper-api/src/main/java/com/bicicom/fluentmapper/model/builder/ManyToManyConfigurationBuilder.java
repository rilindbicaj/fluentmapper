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


    /**
     * <p>
     * Specifies this relationship as mapped by the owning side, with the property used to create
     * the builder through `withMany()`. A shorthand so the same expression does not have to be
     * passed twice.
     * </p>
     * Meaning, this mapping -
     * <pre>
     *     {@code
     *       modelBuilder.hasMany(Address::getUsers)
     *                      .withMany(User::getAddresses)
     *                      .mappedBy(User::getAddresses);
     *       }
     * </pre>
     * <p>
     * is equivalent to -
     * </p>
     * <pre>
     *     {@code
     *       modelBuilder.hasMany(Address::getUsers)
     *                      .withMany(User::getAddresses)
     *                      .isMapped();
     *       }
     * </pre>
     * noting the model User as the owner of the relationship, and the one who maps
     * this relationship further.
     *
     * @return the same builder for further chaining
     */

    ManyToManyConfigurationBuilder<S, T> isMapped();


}
