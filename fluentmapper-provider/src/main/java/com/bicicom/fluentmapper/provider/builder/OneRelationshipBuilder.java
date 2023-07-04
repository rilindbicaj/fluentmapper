package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.expression.Expression;
import com.bicicom.fluentmapper.model.builder.ManyToOneConfigurationBuilder;
import com.bicicom.fluentmapper.model.builder.OneRelationshipConfigurationBuilder;
import com.bicicom.fluentmapper.model.builder.OneToOneConfigurationBuilder;
import com.bicicom.fluentmapper.provider.expression.parser.ExpressionMetadata;
import com.bicicom.fluentmapper.provider.model.mutable.EntityModel;
import com.bicicom.fluentmapper.provider.model.mutable.ManyToOneRelationship;
import com.bicicom.fluentmapper.provider.model.mutable.OneToOneRelationship;

import java.util.Collection;

public class OneRelationshipBuilder<S, T> extends BaseModelBuilder implements OneRelationshipConfigurationBuilder<S, T> {

    private final EntityModel entityModel;

    /**
     * The expression metadata used to create this builder.
     */
    private final ExpressionMetadata builderContext;

    OneRelationshipBuilder(EntityModel entityModel, ExpressionMetadata builderContext) {
        this.entityModel = entityModel;
        this.builderContext = builderContext;
    }

    @Override
    public OneToOneConfigurationBuilder<T, S> withOne(Expression<S, T> expression) {
        var parsedExpression = parse(expression);
        var relationship = new OneToOneRelationship();
        relationship.setName(builderContext.property());
        relationship.setTargetEntity(parsedExpression.sourceClass());

        entityModel.addRelationship(relationship);

        return new OneToOneBuilder<>(relationship, parsedExpression);
    }

    @Override
    public OneToOneConfigurationBuilder<T, S> withOne() {
        var relationship = new OneToOneRelationship();
        relationship.setName(builderContext.property());
        relationship.setTargetEntity(builderContext.targetClass());

        entityModel.addRelationship(relationship);

        return new OneToOneBuilder<>(relationship, builderContext);
    }

    @Override
    public ManyToOneConfigurationBuilder<T, S> withMany(Expression<S, Collection<T>> expression) {
        var relationship = new ManyToOneRelationship();
        relationship.setName(builderContext.property());
        relationship.setTargetEntity(parse(expression).sourceClass());

        entityModel.addRelationship(relationship);

        return new ManyToOneBuilder<>(relationship);
    }

    @Override
    public ManyToOneConfigurationBuilder<T, S> withMany() {
        var relationship = new ManyToOneRelationship();
        relationship.setName(builderContext.property());
        relationship.setTargetEntity(builderContext.targetClass()); // T class

        entityModel.addRelationship(relationship);

        return new ManyToOneBuilder<>(relationship);
    }
}
