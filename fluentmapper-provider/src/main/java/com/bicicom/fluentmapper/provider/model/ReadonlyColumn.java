package com.bicicom.fluentmapper.provider.model;

public interface ReadonlyColumn {
    String getName();
    int getLength();
    boolean isNullable();
    boolean isUnique();
}
