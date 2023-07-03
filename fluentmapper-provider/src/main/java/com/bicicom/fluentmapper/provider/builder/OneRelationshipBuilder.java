package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.expression.Expression;
import com.bicicom.fluentmapper.model.builder.ManyToOneConfigurationBuilder;
import com.bicicom.fluentmapper.model.builder.OneRelationshipConfigurationBuilder;
import com.bicicom.fluentmapper.model.builder.OneToOneConfigurationBuilder;
import com.bicicom.fluentmapper.provider.model.mutable.EntityModel;
import com.bicicom.fluentmapper.provider.model.mutable.ManyToOneRelationship;
import com.bicicom.fluentmapper.provider.model.mutable.OneToOneRelationship;

import java.util.Collection;

public class OneRelationshipBuilder<S, T> extends BaseModelBuilder implements OneRelationshipConfigurationBuilder<S, T> {

    private final EntityModel entityModel;
    private final String hasOne;

    OneRelationshipBuilder(EntityModel entityModel, String hasOne) {
        this.entityModel = entityModel;
        this.hasOne = hasOne;
    }

    @Override
    public OneToOneConfigurationBuilder<T, S> withOne(Expression<S, T> expression) {
        var parsed = parse(expression);
        var relationship = new OneToOneRelationship();
        relationship.setName(hasOne);
        relationship.setTargetEntity(parsed.sourceClass());

        entityModel.addRelationship(relationship);

        return new OneToOneBuilder<>(relationship, parsed.property());
    }

    @Override
    public ManyToOneConfigurationBuilder<T, S> withMany(Expression<S, Collection<T>> expression) {
        var relationship = new ManyToOneRelationship();
        relationship.setName(hasOne);
        relationship.setTargetEntity(parse(expression).sourceClass());

        entityModel.addRelationship(relationship);

        return new ManyToOneBuilder<>(relationship);
    }
}
