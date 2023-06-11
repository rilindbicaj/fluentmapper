package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.expression.Expression;
import com.bicicom.fluentmapper.model.builder.*;
import com.bicicom.fluentmapper.provider.model.ReadonlyEntityModel;
import com.bicicom.fluentmapper.provider.model.mutable.BasicAttribute;
import com.bicicom.fluentmapper.provider.model.mutable.EntityModel;
import com.bicicom.fluentmapper.provider.model.mutable.Key;
import com.bicicom.fluentmapper.provider.model.mutable.Table;

public class EntityModelBuilder<S> extends BaseModelBuilder implements ModelBuilder<S> {

    private final EntityModel entityModel;

    private EntityModelBuilder(String qualifiedEntityClass) {
        super();
        this.entityModel = EntityModel.fromClass(qualifiedEntityClass);
    }

    public static <T> EntityModelBuilder<T> forEntity(String qualifiedEntityClass) {
        return new EntityModelBuilder<>(qualifiedEntityClass);
    }

    public ReadonlyEntityModel getModel() {
        return this.entityModel;
    }

    @Override
    public <T> KeyConfigurationBuilder<S, T> hasKey(Expression<S, T> expression) {
        var metadata = parse(expression);
        String property = metadata.property();

        Key key = new Key(property);
        this.entityModel.addKey(key);

        return new KeyBuilder<>(key);
    }

    @Override
    public PropertyConfigurationBuilder property(Expression<S, ?> expression) {
        var metadata = parse(expression);
        BasicAttribute basicAttribute = new BasicAttribute(metadata.property());
        entityModel.addBasicAttribute(basicAttribute);

        return new PropertyBuilder(basicAttribute);
    }

    @Override
    public TableConfigurationBuilder toTable(String tableName) {
        Table table = new Table();
        table.setName(tableName);

        entityModel.setTable(table);

        return new TableBuilder(table);
    }

    @Override
    public <T> PartialOneRelationshipConfigurationBuilder<T, S> hasOne(Expression<S, T> expression) {
        return null;
    }

    @Override
    public <T> PartialManyRelationshipConfigurationBuilder hasMany(Expression<S, T> expression) {
        return null;
    }
}
