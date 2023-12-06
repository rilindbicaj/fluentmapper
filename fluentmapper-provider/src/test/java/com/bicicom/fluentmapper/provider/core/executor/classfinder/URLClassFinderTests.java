package com.bicicom.fluentmapper.provider.core.executor.classfinder;

import com.bicicom.fluentmapper.provider.core.classloader.ModelClassLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("URLClassFinder tests")
public class URLClassFinderTests {

    private static final String MAPPINGS_PACKAGE = "com.bicicom.fluentmapper.provider.testutils.mappings";
    private static final String CLASSPATH = System.getProperty("user.dir") + "/target/classes";
    private URLClassFinder classFinder;

    @BeforeEach
    public void initializeModelClassloader() {
        //ModelClassLoader.initialize(CLASSPATH);
    }

    @Test
    @DisplayName("Should find all mapping classes in given correct path and package")
    public void givenPath_containsMappings_shouldFindAllMappingClasses() {
        var classFinder = new SystemLoaderClassFinder(ModelClassLoader.INSTANCE.getClassLoader());

        var list = classFinder.findMappingClasses(MAPPINGS_PACKAGE);
        Assertions.assertEquals(2, list.size());
    }

}
