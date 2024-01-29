package dev.bici.fluentmapper.provider.builder;

import dev.bici.fluentmapper.expression.Expression;
import dev.bici.fluentmapper.model.builder.ManyToOneConfigurationBuilder;
import dev.bici.fluentmapper.model.builder.OneRelationshipConfigurationBuilder;
import dev.bici.fluentmapper.model.builder.OneToOneConfigurationBuilder;
import dev.bici.fluentmapper.provider.expression.parser.ExpressionMetadata;
import dev.bici.fluentmapper.provider.model.Entity;
import dev.bici.fluentmapper.provider.model.ManyToOne;
import dev.bici.fluentmapper.provider.model.OneToOne;

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
        var parsedExpression = expressionParser.parse(expression);
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
        relationship.setTargetEntity(expressionParser.parse(expression).sourceClass());

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
