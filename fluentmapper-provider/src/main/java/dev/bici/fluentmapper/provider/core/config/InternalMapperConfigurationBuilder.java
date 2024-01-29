package dev.bici.fluentmapper.provider.core.config;

import dev.bici.fluentmapper.core.MapperConfigurationBuilder;
import dev.bici.fluentmapper.core.config.MapperConfiguration;

public final class InternalMapperConfigurationBuilder implements MapperConfigurationBuilder {

    private String[] additionalExportPaths = new String[]{};
    private String mappingsPackage = "";
    private String classpath = "";

    private InternalMapperConfigurationBuilder() {
    }

    public static InternalMapperConfigurationBuilder create() {
        return new InternalMapperConfigurationBuilder();
    }

    @Override
    public MapperConfigurationBuilder withMappingsPackage(String mappingsPackage) {
        this.mappingsPackage = mappingsPackage;
        return this;
    }

    @Override
    public MapperConfigurationBuilder withAdditionalExportPaths(String... exportPaths) {
        this.additionalExportPaths = exportPaths;
        return this;
    }

    @Override
    public MapperConfigurationBuilder withClasspath(String classpath) {
        this.classpath = classpath;
        return this;
    }

    public MapperConfiguration build() {
        return new MapperConfiguration(
                this.mappingsPackage,
                this.additionalExportPaths,
                this.classpath
        );
    }

}
