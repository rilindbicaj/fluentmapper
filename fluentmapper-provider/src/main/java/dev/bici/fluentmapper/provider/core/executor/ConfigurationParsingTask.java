package dev.bici.fluentmapper.provider.core.executor;

import dev.bici.fluentmapper.provider.model.Entity;
import dev.bici.fluentmapper.provider.parser.EntityModelParser;

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
