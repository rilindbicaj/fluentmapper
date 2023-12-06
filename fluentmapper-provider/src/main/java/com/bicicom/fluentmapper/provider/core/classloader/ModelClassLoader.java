package com.bicicom.fluentmapper.provider.core.classloader;

/**
 * Allows the loading of entity classes at runtime. Holds the classloader capable
 * of loading these classes from the client project's classpath.
 */
public enum ModelClassLoader {
    INSTANCE;

    private ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    public ClassLoader getClassLoader() {
        return this.classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

}
