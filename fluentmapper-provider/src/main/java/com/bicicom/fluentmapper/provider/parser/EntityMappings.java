package com.bicicom.fluentmapper.provider.parser;

public class EntityMappings {

    private final String stringifiedMappings;

    public EntityMappings(String stringifiedMappings) {
        this.stringifiedMappings = stringifiedMappings;
    }

    public String getMappingsString() {
        return stringifiedMappings;
    }
}
