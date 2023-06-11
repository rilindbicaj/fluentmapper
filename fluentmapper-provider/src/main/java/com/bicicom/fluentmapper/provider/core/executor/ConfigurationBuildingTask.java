package com.bicicom.fluentmapper.provider.core.executor;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.provider.builder.EntityModelBuilder;
import com.bicicom.fluentmapper.provider.model.ReadonlyEntityModel;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.Callable;

public class ConfigurationBuildingTask<T> implements Callable<ReadonlyEntityModel> {

    private final EntityMapper<T> mapper;
    private final EntityModelBuilder<T> modelBuilder;

    ConfigurationBuildingTask(EntityMapper<T> mapper) {
        this.mapper = mapper;
        this.modelBuilder = EntityModelBuilder.forEntity(parseMapperModel());
    }

    private String parseMapperModel() {
        return ((ParameterizedType) this.mapper.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0].getTypeName();
    }

    @Override
    public ReadonlyEntityModel call() {
        mapper.configure(this.modelBuilder);
        return modelBuilder.getModel();
    }
}
