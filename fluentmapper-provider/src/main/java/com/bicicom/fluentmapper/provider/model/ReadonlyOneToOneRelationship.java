package com.bicicom.fluentmapper.provider.model;

public non-sealed interface ReadonlyOneToOneRelationship extends ReadonlyRelationship {
    String getMappedBy();

    ReadonlyJoinColumn getJoinColumn();
}
