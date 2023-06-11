package com.bicicom.fluentmapper.provider.model;

public non-sealed interface ReadonlyBasicAttribute extends Attribute {
    String getName();

    boolean isOptional();

    ReadonlyColumn getColumn();
}
