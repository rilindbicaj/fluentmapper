package com.bicicom.fluentmapper.core;

import com.bicicom.fluentmapper.model.builder.ModelBuilder;

public interface EntityMapper<T> {

    void configure(ModelBuilder<T> modelBuilder);

}
