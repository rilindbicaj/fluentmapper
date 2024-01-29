package dev.bici.fluentmapper.provider.testutils.nestedmappings;

import dev.bici.fluentmapper.core.EntityMapper;
import dev.bici.fluentmapper.model.builder.ModelBuilder;

public class Model {

    class ModelMapping implements EntityMapper<Model> {

        @Override
        public void configure(ModelBuilder<Model> modelBuilder) {

        }
    }
}
