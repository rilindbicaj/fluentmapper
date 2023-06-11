package com.bicicom.fluentmapper.provider.model;

public sealed interface Attribute
        permits ReadonlyKey,
        ReadonlyRelationship,
        ReadonlyBasicAttribute {
}
