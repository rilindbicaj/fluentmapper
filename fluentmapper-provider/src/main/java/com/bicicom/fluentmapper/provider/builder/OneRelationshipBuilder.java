package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.expression.Expression;
import com.bicicom.fluentmapper.model.builder.ManyToOneConfigurationBuilder;
import com.bicicom.fluentmapper.model.builder.OneRelationshipConfigurationBuilder;
import com.bicicom.fluentmapper.model.builder.OneToOneConfigurationBuilder;
import com.bicicom.fluentmapper.provider.expression.parser.ExpressionMetadata;
import com.bicicom.fluentmapper.provider.model.Entity;
import com.bicicom.fluentmapper.provider.model.ManyToOne;
import com.bicicom.fluentmapper.provider.model.OneToOne;

import java.util.Collection;

public class OneRelationshipBuilder<S, T> extends BaseModelBuilder implements OneRelationshipConfigurationBuilder<S, T> {

    private final Entity entityModel;

    /**
     * The expression metadata used to create this builder.
     */
    private final ExpressionMetadata builderContext;

    OneRelationshipBuilder(Entity entityModel, ExpressionMetadata builderContext) {
        this.entityModel = entityModel;
        this.builderContext = builderContext;
    }

    @Override
    public OneToOneConfigurationBuilder<T, S> withOne(Expression<S, T> expression) {
        var parsedExpression = parse(expression);
        var relationship = new OneToOne();
        relationship.setName(builderContext.property());
        relationship.setTargetEntity(parsedExpression.sourceClass());

        entityModel.getAttributes()
                .getOneToOne()
                .add(relationship);

        return new OneToOneBuilder<>(relationship, parsedExpression);
    }

    @Override
    public OneToOneConfigurationBuilder<T, S> withOne() {
        var relationship = new OneToOne();
        relationship.setName(builderContext.property());
        relationship.setTargetEntity(builderContext.targetClass());

        entityModel.getAttributes()
                .getOneToOne()
                .add(relationship);

        return new OneToOneBuilder<>(relationship, builderContext);
    }

    @Override
    public ManyToOneConfigurationBuilder<T, S> withMany(Expression<S, Collection<T>> expression) {
        var relationship = new ManyToOne();
        relationship.setName(builderContext.property());
        relationship.setTargetEntity(parse(expression).sourceClass());

        entityModel.getAttributes()
                .getManyToOne()
                .add(relationship);

        return new ManyToOneBuilder<>(relationship);
    }

    @Override
    public ManyToOneConfigurationBuilder<T, S> withMany() {
        var relationship = new ManyToOne();
        relationship.setName(builderContext.property());
        relationship.setTargetEntity(builderContext.targetClass()); // T class

        entityModel.getAttributes()
                .getManyToOne()
                .add(relationship);

        return new ManyToOneBuilder<>(relationship);
    }
}
