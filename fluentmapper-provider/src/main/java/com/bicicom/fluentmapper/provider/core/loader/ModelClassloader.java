package com.bicicom.fluentmapper.provider.core.loader;


import java.io.IOException;
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

    public ClassLoader getClassloader() {
        return classLoader;
    }

    public void setClassloader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public void release() throws IOException {
        if (this.classLoader instanceof URLClassLoader) {
            ((URLClassLoader) this.classLoader).close();
        }
    }
}
