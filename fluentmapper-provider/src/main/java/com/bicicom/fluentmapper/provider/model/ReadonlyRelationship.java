package com.bicicom.fluentmapper.provider.model;

import com.bicicom.fluentmapper.provider.model.mutable.Relationship;

public sealed interface ReadonlyRelationship
        extends Attribute
        permits
        Relationship {
    String getName();

    String getTargetEntity();

    String getMappedBy();

    ReadonlyJoinColumn getJoinColumn();
}
