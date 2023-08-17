package com.bicicom.fluentmapper.provider.core.executor.classfinder;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.provider.core.exception.FluentMapperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Locates mapping classes by using the system classloader. This class finder is used
 * when the library is executed by the application using it, meaning the necessary mapping
 * classes have been loaded together with the application, therefore they're present in the
 * classloader and can be accessed from there.
 *
 * </p>
 * <p>
 * In cases where the mapping classes are not on the classpath during the library's execution,
 * the {@link URLClassFinder} is the appropriate implementation for the job.
 * </p>
 */

public final class SystemLoaderClassFinder implements MappingClassFinder {

    private static final Logger logger = LoggerFactory.getLogger(SystemLoaderClassFinder.class);

    private final ClassLoader classLoader;

    /**
     * Creates a classfinder using the system's class loader.
     */
    SystemLoaderClassFinder() {
        this.classLoader = ClassLoader.getSystemClassLoader();
    }

    /**
     * Creates a classfinder using the provided classloader for locating the resources.
     *
     * @param classLoader the classloader used for resource fetching
     */
    SystemLoaderClassFinder(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public List<Class<? extends EntityMapper<?>>> findMappingClasses(String packageName) {
        String path = packageName.replace('.', '/');

        List<String> definedPackages = Arrays.stream(this.classLoader.getDefinedPackages())
                .map(Package::getName)
                .toList();

        logger.info("Path to search for is {}", path);
        logger.info("Defined packages are {}", definedPackages);

        var resources = this.classLoader.resources(path);

        if (resources.findAny().isEmpty()) {
            // Not a fan of this vague exception but these are the limits of the classloader... maybe
            throw new FluentMapperException("Incorrect package name " + packageName
                    + ". Could not locate resource or package contains no files.");
        }

        List<File> files = this.classLoader.resources(path)
                .map(URL::getFile)
                .map(File::new)
                .toList();

        List<Class<? extends EntityMapper<?>>> classes = files.stream()
                .distinct() // Find out why duplicate URLs are generated in test files
                .map(file -> findClasses(file, packageName))
                .flatMap(List::stream)
                .toList();

        return classes.stream()
                .filter(EntityMapper.class::isAssignableFrom)
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
