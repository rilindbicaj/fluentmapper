package com.bicicom.fluentmapper.provider.core.executor;

import com.bicicom.fluentmapper.provider.model.Entity;
import com.bicicom.fluentmapper.provider.parser.EntityModelParser;

import java.util.concurrent.Callable;

public class ConfigurationParsingTask implements Callable<String> {

    private final Iterable<Entity> entityModel;

    public ConfigurationParsingTask(Iterable<Entity> entityModel) {
        this.entityModel = entityModel;
    }

    @Override
    public String call() {
        var parser = EntityModelParser.getInstance();
        return parser.parseModels(this.entityModel);
    }
}
