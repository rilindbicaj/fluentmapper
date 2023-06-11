package com.bicicom.fluentmapper.provider.model;

public non-sealed interface ReadonlyKey extends Attribute {
    String getName();

    ReadonlyColumn getColumn();
}
