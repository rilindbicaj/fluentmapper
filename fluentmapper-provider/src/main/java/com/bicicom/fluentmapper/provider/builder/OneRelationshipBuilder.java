package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.expression.Expression;
import com.bicicom.fluentmapper.model.builder.OneRelationshipConfigurationBuilder;
import com.bicicom.fluentmapper.model.builder.OneToManyConfigurationBuilder;
import com.bicicom.fluentmapper.model.builder.OneToOneConfigurationBuilder;

import java.util.Collection;

public class OneRelationshipBuilder<S, T> extends BaseModelBuilder implements OneRelationshipConfigurationBuilder<S, T> {
    @Override
    public OneToOneConfigurationBuilder<T, S> withOne(Expression<S, T> expression) {
        return null;
    }

    @Override
    public OneToManyConfigurationBuilder<T, S> withMany(Expression<S, Collection<T>> expression) {
        return null;
    }
}
