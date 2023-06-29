package com.bicicom.fluentmapper.core.config;

public record MapperConfiguration(
        String[] exportPaths,
        boolean exports,
        String mappingsPackage,
        String mappingsPath,
        String pathStrategy
) {
}
