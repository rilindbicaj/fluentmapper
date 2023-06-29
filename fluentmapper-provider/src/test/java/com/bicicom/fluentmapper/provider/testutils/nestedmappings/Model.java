package com.bicicom.fluentmapper.provider.testutils.nestedmappings;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.model.builder.ModelBuilder;

public class Model {

    class ModelMapping implements EntityMapper<Model> {

        @Override
        public void configure(ModelBuilder<Model> modelBuilder) {

        }
    }
}
