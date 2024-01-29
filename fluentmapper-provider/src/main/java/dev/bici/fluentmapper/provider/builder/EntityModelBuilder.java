package dev.bici.fluentmapper.provider.builder;

import dev.bici.fluentmapper.expression.Expression;
import dev.bici.fluentmapper.model.builder.*;
import dev.bici.fluentmapper.provider.model.Basic;
import dev.bici.fluentmapper.provider.model.Entity;
import dev.bici.fluentmapper.provider.model.Id;
import dev.bici.fluentmapper.provider.model.Table;
import dev.bici.fluentmapper.provider.model.bootstrapper.EntityModelBootstrapper;

import java.util.Collection;

public class EntityModelBuilder<S> extends BaseModelBuilder implements ModelBuilder<S> {

    private final Entity entityModel;

    private EntityModelBuilder(String qualifiedEntityClass) {
        this.entityModel = EntityModelBootstrapper.forClass(qualifiedEntityClass)
                .bootstrap();
    }

    public static <T> EntityModelBuilder<T> forEntity(String qualifiedEntityClass) {
        return new EntityModelBuilder<>(qualifiedEntityClass);
    }

    public Entity getModel() {
        return this.entityModel;
    }

    @Override
    public <T> KeyConfigurationBuilder<S, T> hasKey(Expression<S, T> expression) {
        var metadata = expressionParser.parse(expression);
        var key = new Id();
        key.setName(metadata.property());

        this.entityModel.getAttributes().getId().add(key);

        return new KeyBuilder<>(key);
    }

    @Override
    public PropertyConfigurationBuilder property(Expression<S, ?> expression) {
        var metadata = expressionParser.parse(expression);
        var basicAttribute = new Basic();
        basicAttribute.setName(metadata.property());

        entityModel.getAttributes().getBasic().add(basicAttribute);

        return new PropertyBuilder(basicAttribute);
    }

    @Override
    public TableConfigurationBuilder toTable(String tableName) {
        var table = new Table();

        table.setName(tableName);
        table.setSchema("public");
        entityModel.setTable(table);

        return new TableBuilder(table);
    }

    @Override
    public <T> OneRelationshipConfigurationBuilder<T, S> hasOne(Expression<S, T> expression) {
        var parsedExpression = expressionParser.parse(expression);

        return new OneRelationshipBuilder<>(entityModel, parsedExpression);
    }

    @Override
    public <T> ManyRelationshipConfigurationBuilder<T, S> hasMany(Expression<S, Collection<T>> expression) {
        var parsedExpression = expressionParser.parse(expression);

        return new ManyRelationshipBuilder<>(entityModel, parsedExpression);
    }


}
