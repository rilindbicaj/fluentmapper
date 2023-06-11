package com.bicicom.fluentmapper.provider.model;

public interface ReadonlyTable {
    String getSchema();
    String getName();
    String getCatalog();
}
