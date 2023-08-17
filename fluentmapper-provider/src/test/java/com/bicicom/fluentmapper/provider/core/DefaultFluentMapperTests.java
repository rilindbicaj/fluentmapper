package com.bicicom.fluentmapper.provider.core;

import com.bicicom.fluentmapper.core.FluentMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DefaultFluentMapper tests")
public class DefaultFluentMapperTests {

    private static final String MAPPINGS_PACKAGE = "com.bicicom.fluentmapper.provider.testutils.mappings";

    @Test
    @DisplayName("Should successfully execute on a correctly configured instance")
    public void givenCorrectConfig_shouldExecuteFine() {
        FluentMapper fluentMapper = FluentFactory.createConfigured(config -> {
            config.withMappingsPackage(MAPPINGS_PACKAGE);
        });

        System.out.println(fluentMapper.execute());
    }

}
