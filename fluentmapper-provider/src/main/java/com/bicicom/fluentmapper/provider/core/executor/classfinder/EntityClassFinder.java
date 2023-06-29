package com.bicicom.fluentmapper.provider.core.executor.classfinder;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.provider.core.FluentMapperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This code saves me an additional dependency on the Reflections library. It is not mine.
 *
 * @see <a href="https://dzone.com/articles/get-all-classes-within-package">The code in the original post</a>
 */

public class EntityClassFinder {

    private static final Logger logger = LoggerFactory.getLogger(EntityClassFinder.class);

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     */
    public static List<Class<? extends EntityMapper<?>>> getClasses(String packageName) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String path = packageName.replace('.', '/');

        logger.info("Path to search for is {}", path);
        logger.info("Defined packages are {}", Arrays.stream(classLoader.getDefinedPackages())
                .map(Package::getName)
                .toList()
        );

        if (classLoader.getResource(path) == null) {
            // Not a fan of this vague exception but these are the limits of the classloader... maybe
            throw new FluentMapperException("Incorrect package name " + packageName
                    + ". Could not locate resource or package contains no files.");
        }

        List<File> files = classLoader.resources(path)
                .map(URL::getFile)
                .map(File::new)
                .toList();

        List<Class<? extends EntityMapper<?>>> classes = files.stream()
                .map(file -> findClasses(file, packageName))
                .flatMap(List::stream)
                .distinct() // Find out why duplicate URLs are generated in test files
                .toList();

        return classes.stream()
                .filter(EntityMapper.class::isAssignableFrom)
                .toList();
    }

    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param file        The base directory, or a file
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     */
    private static List<Class<? extends EntityMapper<?>>> findClasses(File file, String packageName) {
        List<Class<? extends EntityMapper<?>>> classes = new ArrayList<>();

        if (!file.exists()) {
            return classes;
        }

        if (!file.isDirectory()) {
            classes.add(getClassFromFile(file, packageName));
            return classes;
        }

        File[] directoryFiles = file.listFiles();
        assert directoryFiles != null;

        Arrays.stream(directoryFiles)
                .forEach(directory -> classes.addAll(findClasses(directory, packageName)));

        return classes;
    }

    @SuppressWarnings("unchecked")
    private static Class<? extends EntityMapper<?>> getClassFromFile(File file, String packageName) {
        if (file.getName().endsWith(".class")) {
            String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
            try {
                return (Class<? extends EntityMapper<?>>) Class.forName(className);
            } catch (ClassNotFoundException e) {
                throw new FluentMapperException("Could not load class " + className);
            }
        }
        return null;
    }

}
