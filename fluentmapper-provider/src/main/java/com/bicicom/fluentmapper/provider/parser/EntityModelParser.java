package com.bicicom.fluentmapper.provider.parser;

import com.bicicom.fluentmapper.provider.model.Entity;

/**
 * Handles parsing of the entity model instance configured via the builders.
 */
public interface EntityModelParser {

    static EntityModelParser getInstance() {
        return JAXBModelParser.instance;
    }

    String parseModels(Iterable<Entity> entityModels);

}
