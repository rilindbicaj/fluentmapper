package com.bicicom.fluentmapper.provider.core.executor.classfinder;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.provider.core.loader.ModelClassloader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class URLClassFinder {

    private static final Logger logger = LoggerFactory.getLogger(URLClassFinder.class);
    public static ClassLoader classLoader;

    /**
     * Find all EntityMapper classes in a given classpath and package. The URLClassLoader used here needs
     * to point to the root of the classpath, only then can it navigate to given package and find the classes therein.
     *
     * @param classpath   the root of the classpath
     * @param packageName the package where the files are located
     * @return a list of all mapping classes
     * @throws ClassNotFoundException
     * @throws MalformedURLException
     */
    public List<Class<? extends EntityMapper<?>>> findMappingClasses(String classpath, String packageName) throws ClassNotFoundException, MalformedURLException {
        URL mappingsURL = new URL("file:///" + classpath + "/" + packageName.replace('.', '/') + "/");

        List<Class<?>> mappingClasses = new ArrayList<>();
        List<String> classFiles = this.findClasses(new File(mappingsURL.getFile()), packageName);

        // Necessary for accessing EntityMapper interface
        final ClassLoader thisClassloader = Thread.currentThread().getContextClassLoader();

        URLClassFinder.classLoader = URLClassLoader.newInstance(new URL[]{new URL("file:///" + classpath + "/")}, thisClassloader);
        ModelClassloader.instance().setClassloader(classLoader);

        classFiles.forEach(filename -> {
            try {
                mappingClasses.add(classLoader.loadClass(packageName + "." + filename)); //fuck these fucking exceptions
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Couldn't find class - " + filename, e);
            }
        });

        List<Class<? extends EntityMapper<?>>> mc = new ArrayList<>();

        mappingClasses.forEach(c -> {
            if (EntityMapper.class.isAssignableFrom(c)) {
                mc.add((Class<? extends EntityMapper<?>>) c);
            }
        });

        return mc;
    }

    private List<String> findClasses(File directory, String packageName) throws ClassNotFoundException {
        logger.debug("Locating classes in package - " + packageName);

        List<String> classFiles = new ArrayList<>();

        if (!directory.exists()) {
            return classFiles;
        }

        Arrays.stream(directory.listFiles()).forEach(file -> {
            if (file.isDirectory()) {
                // TODO : Handle directory support
            } else if (file.getName().endsWith(".class")) {
                classFiles.add(file.getName().substring(0, file.getName().length() - 6));
                //classFiles.add(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));
            }
        });

        return classFiles;
    }

}
