package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.expression.Expression;
import com.bicicom.fluentmapper.model.builder.ManyRelationshipConfigurationBuilder;
import com.bicicom.fluentmapper.model.builder.ManyToManyConfigurationBuilder;
import com.bicicom.fluentmapper.model.builder.OneToManyConfigurationBuilder;
import com.bicicom.fluentmapper.provider.model.mutable.EntityModel;
import com.bicicom.fluentmapper.provider.model.mutable.ManyToManyRelationship;
import com.bicicom.fluentmapper.provider.model.mutable.OneToManyRelationship;

import java.util.Collection;

public class ManyRelationshipBuilder<T, S> extends BaseModelBuilder implements ManyRelationshipConfigurationBuilder<T, S> {

    private final String hasMany;
    private final EntityModel entityModel;

    ManyRelationshipBuilder(String hasMany, EntityModel entityModel) {
        this.hasMany = hasMany;
        this.entityModel = entityModel;
    }

    @Override
    public OneToManyConfigurationBuilder<S, T> withOne(Expression<T, S> propertyExpression) {
        var parsedExpression = parse(propertyExpression);

        var relationship = new OneToManyRelationship();
        relationship.setName(hasMany);
        // Move this one level up because its confusing
        relationship.setTargetEntity(parsedExpression.sourceClass());
        relationship.setMappedBy(parsedExpression.property());

        entityModel.addRelationship(relationship);

        return new OneToManyBuilder<>(relationship);
    }

    @Override
    public ManyToManyConfigurationBuilder<S, T> withMany(Expression<T, Collection<S>> propertyExpression) {
        var parsedExpression = parse(propertyExpression);

        var relationship = new ManyToManyRelationship();
        relationship.setName(hasMany);
        // Move this one level up because its confusing
        relationship.setTargetEntity(parsedExpression.sourceClass());

        entityModel.addRelationship(relationship);

        return new ManyToManyBuilder<>(relationship);
    }
}
