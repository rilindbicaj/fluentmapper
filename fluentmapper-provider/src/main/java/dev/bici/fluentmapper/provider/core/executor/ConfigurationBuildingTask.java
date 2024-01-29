package dev.bici.fluentmapper.provider.core.executor;

import dev.bici.fluentmapper.core.EntityMapper;
import dev.bici.fluentmapper.provider.builder.EntityModelBuilder;
import dev.bici.fluentmapper.provider.model.Entity;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.Callable;

public class ConfigurationBuildingTask<T> implements Callable<Entity> {

    private final EntityMapper<T> mapper;
    private final EntityModelBuilder<T> modelBuilder;

    ConfigurationBuildingTask(EntityMapper<T> mapper) {
        this.mapper = mapper;
        this.modelBuilder = EntityModelBuilder.forEntity(parseMapperModel());
    }

    private String parseMapperModel() {
        // TODO - try to make this access less insane. And possibly handle cases of incorrect EntityMapper<T> usage
        //  via exceptions
        return ((ParameterizedType) this.mapper.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0].getTypeName();
    }

    @Override
    public Entity call() {
        mapper.configure(this.modelBuilder);
        return modelBuilder.getModel();
    }
}
