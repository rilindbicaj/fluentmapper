package com.bicicom.fluentmapper.provider.model;

public interface ReadonlyJoinColumn extends ReadonlyColumn {
    String getReferencedColumnName();
}
