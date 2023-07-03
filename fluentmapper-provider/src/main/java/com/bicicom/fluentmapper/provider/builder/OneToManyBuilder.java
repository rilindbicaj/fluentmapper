package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.expression.Expression;
import com.bicicom.fluentmapper.model.builder.OneToManyConfigurationBuilder;
import com.bicicom.fluentmapper.provider.model.mutable.OneToManyRelationship;

public class OneToManyBuilder<S, T> extends BaseModelBuilder implements OneToManyConfigurationBuilder<S, T> {

    private final OneToManyRelationship relationship;

    OneToManyBuilder(OneToManyRelationship oneToManyRelationship) {
        this.relationship = oneToManyRelationship;
    }

    @Override
    public OneToManyConfigurationBuilder<S, T> mappedBy(Expression<T, S> propertyExpression) {
        relationship.setMappedBy(parse(propertyExpression).property());
        return this;
    }
}
