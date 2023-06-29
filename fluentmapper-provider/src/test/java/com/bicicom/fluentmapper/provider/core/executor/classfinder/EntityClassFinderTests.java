package com.bicicom.fluentmapper.provider.core.executor.classfinder;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.provider.core.FluentMapperException;
import com.bicicom.fluentmapper.provider.testutils.mappings.AddressMapping;
import com.bicicom.fluentmapper.provider.testutils.mappings.UserMapping;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("EntityClassFinder tests")
public class EntityClassFinderTests {

    @Test
    @DisplayName("Should find all mapping classes in given package")
    public void givenPackage_packageContainsMappings_shouldFindAllMappings() {
        String mappingsPackage = "com.bicicom.fluentmapper.provider.testutils.mappings";
        List<Class<? extends EntityMapper<?>>> mappingClasses = List.of(UserMapping.class, AddressMapping.class);

        var classes = EntityClassFinder.getClasses(mappingsPackage);
        int expectedLength = 2;
        int actualLength = classes.size();

        assertEquals(expectedLength, actualLength);
        assertTrue(classes.containsAll(mappingClasses));
    }

    @Test
    @DisplayName("Should find mapping classes when nested inside another class")
    public void givenPackage_containsClassWithNestedMapping_shouldFindMapping() {
        String mappingsPackage = "com.bicicom.fluentmapper.provider.testutils.nestedmappings";

        var classes = EntityClassFinder.getClasses(mappingsPackage);
        int expectedLength = 1;
        int actualLength = classes.size();

        assertEquals(expectedLength, actualLength);
    }

    @Test
    @DisplayName("Should throw exception when non-existent package is given")
    public void givenPackage_packageDoesNotExist_shouldThrowException() {
        String mappingsPackage = "com.bicicom.fluentmapper.provider.testutils.doesntexist";

        assertThrows(FluentMapperException.class, () -> EntityClassFinder.getClasses(mappingsPackage));
    }

    @Test
    @DisplayName("Should throw exception if package exists but contains no mappings")
    public void givenPackage_containsNoMappings_shouldReturnEmptyList() {
        String mappingsPackage = "com.bicicom.fluentmapper.provider.testutils.nomappings";

        assertThrows(FluentMapperException.class, () -> EntityClassFinder.getClasses(mappingsPackage));
    }

}
