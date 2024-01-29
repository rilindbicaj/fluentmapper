package dev.bici.fluentmapper.core;

import dev.bici.fluentmapper.model.builder.ModelBuilder;

/**
 * Represents a domain entity mapper, which contains the model's JPA configuration
 * expressed via the model builder API. These classes, referred to as mapping classes,
 * are instantiated by FluentMapper during runtime and used to configure each supported
 * domain entity model's JPA mappings, which it later uses to generate the final JPA compliant
 * XML file.
 * <p>
 * An entity mapper maps exactly one domain model; consequently, each domain model requires its
 * own mapper. If multiple mapper configure the same model, both their results will be present
 * in the final output.
 * <p>
 * Mappers are independent of one another - the final {@code XML} mappings output are a
 * product of each mapper's individual contents. Therefore, they do not affect each other, nor
 * do they have knowledge of each other's existence.
 *
 * @param <T> the domain entity model configured by this mapper
 */
public interface EntityMapper<T> {

    /**
     * Configures the provided {@link ModelBuilder} with the mappings context described
     * in its implementation. The {@link ModelBuilder} reference stays and is used to create
     * instances for all other JPA mapping builders.
     * <p>
     * If the same mapping is configured multiple times, the latest builder to have configured
     * it takes precedence and overrides the previous.
     *
     * @param modelBuilder the {@link ModelBuilder} to be configured in the implementation.
     */
    void configure(ModelBuilder<T> modelBuilder);

}
