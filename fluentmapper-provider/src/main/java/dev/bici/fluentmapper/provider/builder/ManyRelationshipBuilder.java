package dev.bici.fluentmapper.provider.builder;

import dev.bici.fluentmapper.expression.Expression;
import dev.bici.fluentmapper.model.builder.ManyRelationshipConfigurationBuilder;
import dev.bici.fluentmapper.model.builder.ManyToManyConfigurationBuilder;
import dev.bici.fluentmapper.model.builder.OneToManyConfigurationBuilder;
import dev.bici.fluentmapper.provider.expression.parser.ExpressionMetadata;
import dev.bici.fluentmapper.provider.model.Entity;
import dev.bici.fluentmapper.provider.model.ManyToMany;
import dev.bici.fluentmapper.provider.model.OneToMany;

import java.util.Collection;

public class ManyRelationshipBuilder<T, S> extends BaseModelBuilder implements ManyRelationshipConfigurationBuilder<T, S> {

    private final ExpressionMetadata builderContext;
    private final Entity entityModel;

    ManyRelationshipBuilder(Entity entityModel, ExpressionMetadata builderContext) {
        this.entityModel = entityModel;
        this.builderContext = builderContext;
    }

    @Override
    public OneToManyConfigurationBuilder<S, T> withOne(Expression<T, S> propertyExpression) {
        var parsedExpression = expressionParser.parse(propertyExpression);
        var relationship = new OneToMany();

        relationship.setName(builderContext.property());
        relationship.setTargetEntity(parsedExpression.sourceClass());
        relationship.setMappedBy(parsedExpression.property());

        entityModel.getAttributes()
                .getOneToMany()
                .add(relationship);

        return new OneToManyBuilder<>(relationship);
    }

    @Override
    public ManyToManyConfigurationBuilder<S, T> withMany(Expression<T, Collection<S>> propertyExpression) {
        var parsedExpression = expressionParser.parse(propertyExpression);
        var relationship = new ManyToMany();

        relationship.setName(builderContext.property());
        relationship.setTargetEntity(parsedExpression.sourceClass());

        entityModel.getAttributes()
                .getManyToMany()
                .add(relationship);

        return new ManyToManyBuilder<>(relationship, parsedExpression.property());
    }
}
