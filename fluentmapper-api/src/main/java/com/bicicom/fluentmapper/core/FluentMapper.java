package com.bicicom.fluentmapper.core;

/**
 * The entry point of the library, providing the API for its execution. Instances of FluentMapper are
 * created separately via the {@code provider} module. FluentMapper cannot be reconfigured after initialization,
 * therefore subsequent executions result in the same outcome as the initial one.
 */
public interface FluentMapper {

    /**
     * Triggers an execution of the mappings reading and parsing process, generating an
     * XML file as per its configuration.
     */
    void execute();

}
