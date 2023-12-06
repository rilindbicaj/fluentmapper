package com.bicicom.fluentmapper.core;

public interface FluentMapper {

    /**
     * Reads all mapping files and parses them to XML. If configured to output, it will do so
     * before returning the stringified mappings.
     */
    void execute();

}
