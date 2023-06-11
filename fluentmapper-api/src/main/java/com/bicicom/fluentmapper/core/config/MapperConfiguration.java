package com.bicicom.fluentmapper.core.config;

public record MapperConfiguration(
        String exportPath,
        boolean exports,
        String mappingsLocation
) {
}
