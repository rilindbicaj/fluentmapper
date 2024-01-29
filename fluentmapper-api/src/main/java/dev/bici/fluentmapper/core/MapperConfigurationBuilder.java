package dev.bici.fluentmapper.core;

/**
 * A builder for creating the configuration of a {@link FluentMapper} instance. Used in conjunction with
 * an instance provider.
 */
public interface MapperConfigurationBuilder {
    /**
     * Sets the package-location of the mappings to be processed.
     *
     * @param mappingsPackage the name of the package where the mappings to be processed are located
     * @return the same builder for further chaining
     */
    MapperConfigurationBuilder withMappingsPackage(String mappingsPackage);

    /**
     * Sets the additional paths where FluentMapper will export the final, processed mappings, besides
     * the project's build output directory.
     *
     * @param paths an array of paths, system-dependent.
     * @return the same builder for further chaining
     */
    MapperConfigurationBuilder withAdditionalExportPaths(String... paths);

    /**
     * Sets the root classpath of the client project, where the mapping files and domain entity
     * models are located. Used to load these classes at runtime during processing.
     * <p>
     * If FluentMapper is called in a runtime whose classpath does not contain these classes, this
     * property will be used to remotely load these regardless. Otherwise, it will use the default
     * classloader to locate them.
     *
     * @param classpath the root classpath of the project to be processed
     * @return the same builder for further chaining
     */
    MapperConfigurationBuilder withClasspath(String classpath);

}
