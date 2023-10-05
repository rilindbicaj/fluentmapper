package com.bicicom.fluentmapper.provider.core.loader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Allows the loading of entity classes at runtime. Holds the classloader capable
 * of loading these classes from the client project's classpath.
 */
public class ModelClassloader {

    private static final ModelClassloader modelClassloader = new ModelClassloader(
            ModelClassloader.class.getClassLoader()
    );
    private ClassLoader classLoader;

    private ModelClassloader(ClassLoader baseClassloader) {
        this.classLoader = baseClassloader;
    }

    public static ModelClassloader instance() {
        return modelClassloader;
    }

    public static void initialize(String classpath) {
        if (classpath == null || classpath.isBlank()) {
            return;
        }

        var currentClassLoader = Thread.currentThread().getContextClassLoader();
        try {
            URL[] urls = new URL[]{new URL("file:///" + classpath + "/")};
            modelClassloader.classLoader = URLClassLoader.newInstance(urls, currentClassLoader);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public ClassLoader getClassloader() {
        return classLoader;
    }

    public void release() throws IOException {
        if (this.classLoader instanceof URLClassLoader) {
            ((URLClassLoader) this.classLoader).close();
        }
    }
}
