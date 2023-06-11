package com.bicicom.fluentmapper.provider.model;

public sealed interface ReadonlyRelationship extends Attribute permits ReadonlyOneToOneRelationship {
    String getName();

    String getTargetEntity();
}
