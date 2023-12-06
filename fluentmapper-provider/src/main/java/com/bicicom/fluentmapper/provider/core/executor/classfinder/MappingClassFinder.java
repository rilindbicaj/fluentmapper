package com.bicicom.fluentmapper.provider.core.executor.classfinder;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.core.config.MapperConfiguration;
import com.bicicom.fluentmapper.provider.core.classloader.ModelClassLoader;
import com.bicicom.fluentmapper.provider.core.exception.FluentMapperException;

import java.util.List;

/**
 * Responsible for locating classes implementing {@link EntityMapper}.
 */
public sealed interface MappingClassFinder permits URLClassFinder, SystemLoaderClassFinder {

    /**
     * Static factory for getting instances of {@link MappingClassFinder}.
     *
     * @param configuration the mapper's defined configuration
     * @return an instance of a {@link MappingClassFinder} implementation, depending on the configuration
     */
    static MappingClassFinder fromConfig(MapperConfiguration configuration) {
        return switch (configuration.pathStrategy()) {
            case "package" -> new SystemLoaderClassFinder();
            case "path" -> new SystemLoaderClassFinder(ModelClassLoader.INSTANCE.getClassLoader());
            default -> throw new FluentMapperException("Invalid path strategy " + configuration.pathStrategy());
        };
    }

    /**
     * Locates all the mapping classes in the given package.
     *
     * @param packageName the fully qualified name of the package containing the mapping classes.
     * @return a list of all classes implementing the {@link EntityMapper} interface in the given package.
     */
    List<Class<? extends EntityMapper<?>>> findMappingClasses(String packageName);

}
