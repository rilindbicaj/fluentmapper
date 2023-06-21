package com.bicicom.fluentmapper.model.builder;

public interface ManyToOneConfigurationBuilder<S, T> {

    ManyToOneConfigurationBuilder<S, T> joinsOn(String joinColumnName);

}
