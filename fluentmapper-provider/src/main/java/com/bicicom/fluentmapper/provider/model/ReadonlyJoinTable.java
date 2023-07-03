package com.bicicom.fluentmapper.provider.model;

public interface ReadonlyJoinTable {
    String getName();

    ReadonlyJoinColumn getJoinColumn();

    ReadonlyJoinColumn getInverseJoinColumn();
}
