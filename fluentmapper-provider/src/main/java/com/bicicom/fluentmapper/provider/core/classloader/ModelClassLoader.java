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

    /**
     * Overrides the classloader used to load model classes.
     *
     * @param classLoader
     */
    public void setClassLoader(ClassLoader classLoader) {
        /*
         * Not ideal, as this makes the singleton mutable, however it's not the greatest issue considering its confined
         * usage in exactly one line of code.
         */
        this.classLoader = classLoader;
    }

}
