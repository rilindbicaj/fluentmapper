package dev.bici.fluentmapper.provider.core;

import dev.bici.fluentmapper.core.FluentMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DefaultFluentMapper tests")
public class DefaultFluentMapperTests {

    private static final String MAPPINGS_PACKAGE = "dev.bici.fluentmapper.provider.testutils.mappings";

    @Test
    @DisplayName("Should successfully execute on a correctly configured instance")
    public void givenCorrectConfig_shouldExecuteFine() {
        FluentMapper fluentMapper = FluentFactory.createConfigured(config -> {
            config.withMappingsPackage(MAPPINGS_PACKAGE);
        });
        fluentMapper.execute();
    }

}
