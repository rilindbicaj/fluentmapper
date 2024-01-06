package com.bicicom.fluentmapper.provider.core.executor.classfinder;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.provider.core.exception.FluentMapperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Responsible for locating classes implementing {@link EntityMapper}.
 */
public final class MappingClassFinder {

    private static final Logger logger = LoggerFactory.getLogger(MappingClassFinder.class);

    private final ClassLoader classLoader;

    /**
     * Creates a classfinder using the provided classloader for locating the resources.
     *
     * @param classLoader the classloader used for resource fetching
     */
    public MappingClassFinder(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    /**
     * Locates all the mapping classes in the given package.
     *
     * @param packageName the fully qualified name of the package containing the mapping classes.
     * @return a list of all classes implementing the {@link EntityMapper} interface in the given package.
     */
    public List<Class<? extends EntityMapper<?>>> findMappingClasses(String packageName) {
        String path = packageName.replace('.', '/');

        logger.info("Path to search for is {}", path);

        var resources = this.classLoader.resources(path);

        if (resources.findAny().isEmpty()) {
            // Not a fan of this vague exception but these are the limits of the classloader... maybe
            throw new FluentMapperException("Incorrect package name " + packageName
                    + ". Could not locate resource or package contains no files.");
        }

        return this.classLoader.resources(path)
                .map(URL::getFile)
                .distinct() // For some reason it returns duplicate class files in test environments, needs to be researched
                .map(File::new)
                .map(file -> findClasses(file, packageName))
                .flatMap(Collection::stream)
                .filter(EntityMapper.class::isAssignableFrom)
                .peek(mappingClass -> logger.info("Located mapping class {}", mappingClass.getSimpleName()))
                .toList();
    }

    @SuppressWarnings("unchecked")
    private Class<? extends EntityMapper<?>> getClassFromFile(File file, String packageName) {
        if (file.getName().endsWith(".class")) {
            String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
            try {
                return (Class<? extends EntityMapper<?>>) Class.forName(className, false, classLoader);
            } catch (ClassNotFoundException e) {
                throw new FluentMapperException("Could not load class " + className);
            }
        }

        return null;
    }

    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param file        The base directory, or a file
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     */
    private List<Class<? extends EntityMapper<?>>> findClasses(File file, String packageName) {
        // TODO - check if this actually gets subdirs. Also check if you actually want this to happen
        List<Class<? extends EntityMapper<?>>> classes = new ArrayList<>();

        if (!file.exists()) {
            return classes;
        }

        if (!file.isDirectory()) {
            classes.add(getClassFromFile(file, packageName));
            return classes;
        }

        File[] directoryFiles = file.listFiles();

        if (directoryFiles != null) {
            return Arrays.stream(directoryFiles)
                    .map(directory -> findClasses(directory, packageName))
                    .flatMap(List::stream)
                    .toList();
        }

        return classes;
    }

}
