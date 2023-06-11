package com.bicicom.fluentmapper.provider.model;

public interface ReadonlyEntityModel {
    String getName();

    String getEntityClass();

    ReadonlyTable getTable();

    Iterable<? extends ReadonlyKey> getKeys();

    Iterable<? extends ReadonlyBasicAttribute> getBasicAttributes();

    Iterable<? extends ReadonlyRelationship> getRelationships();
}
