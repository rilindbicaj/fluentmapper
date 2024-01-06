package com.bicicom.fluentmapper.core.config;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.core.FluentMapper;

/**
 * Holds the configuration of a {@link FluentMapper} instance.
 *
 * @param mappingsPackage       the package in which the {@link EntityMapper} classes are located.
 * @param additionalExportPaths the additional paths where the final output should be exported to, besides the classpath.
 *                              <b>Not recommended to export anywhere but the classpath,</b> but can be leveraged to export
 *                              to the project's source files if desired.
 * @param classpath             the classpath of the project where the {@link EntityMapper} classes are located, in cases
 *                              where {@link FluentMapper} runs outside the context of the client project (as is the case
 *                              for the Maven Plugin).
 */
public record MapperConfiguration(
        String mappingsPackage,
        String[] additionalExportPaths,
        String classpath
) {
}
