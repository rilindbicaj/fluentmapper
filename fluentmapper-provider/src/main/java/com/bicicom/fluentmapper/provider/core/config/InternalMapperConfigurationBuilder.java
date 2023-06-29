package com.bicicom.fluentmapper.provider.core.config;

import com.bicicom.fluentmapper.core.MapperConfigurationBuilder;
import com.bicicom.fluentmapper.core.config.MapperConfiguration;

public final class InternalMapperConfigurationBuilder implements MapperConfigurationBuilder {

    private String[] exportPaths;
    private boolean exports = false;
    private String mappingsPackage;
    private String mappingsPath;
    private String pathStrategy = "package";

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
    public MapperConfigurationBuilder withMappingsPath(String mappingsPath) {
        this.mappingsPath = mappingsPath;
        this.pathStrategy = "path";
        return this;
    }

    @Override
    public MapperConfigurationBuilder exports() {
        this.exports = true;
        return this;
    }

    @Override
    public MapperConfigurationBuilder exportsTo(String... exportPaths) {
        this.exportPaths = exportPaths;
        this.exports = true;
        return this;
    }

    public MapperConfiguration build() {
        return new MapperConfiguration(
                this.exportPaths,
                this.exports,
                this.mappingsPackage,
                this.mappingsPath,
                this.pathStrategy
        );
    }

}
