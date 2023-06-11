package com.bicicom.fluentmapper.provider.core.config;

import com.bicicom.fluentmapper.core.MapperConfigurationBuilder;
import com.bicicom.fluentmapper.core.config.MapperConfiguration;

public final class InternalMapperConfigurationBuilder implements MapperConfigurationBuilder {

    private String exportPath = "src/main/resources/META-INF/orm.xml";
    private boolean exports = false;
    private String mappingsLocation;

    private InternalMapperConfigurationBuilder() {
    }

    public static InternalMapperConfigurationBuilder create() {
        return new InternalMapperConfigurationBuilder();
    }

    @Override
    public MapperConfigurationBuilder withMappingsPackage(String mappingsPackage) {
        this.mappingsLocation = mappingsPackage;
        return this;
    }

    @Override
    public MapperConfigurationBuilder exports() {
        this.exports = true;
        return this;
    }

    @Override
    public MapperConfigurationBuilder exports(String exportPath) {
        this.exportPath = exportPath;
        this.exports = true;
        return this;
    }

    public MapperConfiguration build() {
        return new MapperConfiguration(
                this.exportPath,
                this.exports,
                this.mappingsLocation
        );
    }

}
