package com.bicicom.fluentmapper.provider.model;

public non-sealed interface ReadonlyOneToManyRelationship extends ReadonlyRelationship {
    String getMappedBy();

    ReadonlyJoinColumn getJoinColumn();
}
