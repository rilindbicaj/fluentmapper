package com.bicicom.fluentmapper.provider.core.executor;

import com.bicicom.fluentmapper.provider.model.ReadonlyEntityModel;
import com.bicicom.fluentmapper.provider.parser.EntityModelParser;

import java.util.Collection;
import java.util.concurrent.Callable;

public class ConfigurationParsingTask implements Callable<String> {

    private final EntityModelParser parser = new EntityModelParser();
    private final Collection<ReadonlyEntityModel> entityModels;

    public ConfigurationParsingTask(Collection<ReadonlyEntityModel> entityModels) {
        this.entityModels = entityModels;
    }

    @Override
    public String call() {
        return parser.parseModels(this.entityModels).getMappingsString();
    }
}
