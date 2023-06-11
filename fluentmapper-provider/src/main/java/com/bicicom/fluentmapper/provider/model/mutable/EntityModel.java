package com.bicicom.fluentmapper.provider.model.mutable;

import com.bicicom.fluentmapper.provider.model.Attribute;
import com.bicicom.fluentmapper.provider.model.ReadonlyEntityModel;
import com.bicicom.fluentmapper.provider.model.ReadonlyRelationship;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EntityModel implements ReadonlyEntityModel {

    private final Map<String, Attribute> attributes = new HashMap<>();
    private String name;
    private String _class;
    private Table table;


    EntityModel(String name, String entityClass) {
        this.name = name;
        this._class = entityClass;
    }

    public static EntityModel fromClass(String qualifiedClassName) {
        return EntityModelBootstrapper.forClass(qualifiedClassName).bootstrap();
    }

    @Override
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEntityClass() {
        return _class;
    }


    public void setEntityClass(String entityClass) {
        this._class = entityClass;
    }

    @Override
    public Table getTable() {
        return table;
    }


    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public Collection<Key> getKeys() {
        return attributes.values().stream()
                .filter(Key.class::isInstance)
                .map(Key.class::cast)
                .toList();
    }


    public void addKey(Key key) {
        this.attributes.put(key.getName(), key);
    }

    @Override
    public Collection<BasicAttribute> getBasicAttributes() {
        return attributes.values().stream()
                .filter(BasicAttribute.class::isInstance)
                .map(BasicAttribute.class::cast)
                .toList();
    }


    public void addBasicAttribute(BasicAttribute basicAttribute) {
        this.attributes.put(basicAttribute.getName(), basicAttribute);
    }

    @Override
    public Collection<? extends ReadonlyRelationship> getRelationships() {
        return attributes.values().stream()
                .filter(ReadonlyRelationship.class::isInstance)
                .map(ReadonlyRelationship.class::cast)
                .toList();
    }


    public void addRelationship(ReadonlyRelationship relationship) {
        //
    }

}
