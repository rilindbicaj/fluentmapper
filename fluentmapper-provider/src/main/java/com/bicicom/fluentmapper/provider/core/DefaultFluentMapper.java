package com.bicicom.fluentmapper.provider.core;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.core.FluentMapper;
import com.bicicom.fluentmapper.core.config.MapperConfiguration;
import com.bicicom.fluentmapper.provider.core.classloader.ModelClassLoader;
import com.bicicom.fluentmapper.provider.core.exception.FluentMapperException;
import com.bicicom.fluentmapper.provider.core.executor.TaskExecutor;
import com.bicicom.fluentmapper.provider.core.executor.classfinder.MappingClassFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

final class DefaultFluentMapper implements FluentMapper {

    private static final Logger logger = LoggerFactory.getLogger(FluentMapper.class);
    private static final Function<Class<? extends EntityMapper<?>>, EntityMapper<?>> toMapper = (mappingClass) -> {
        try {
            Constructor<?> constructor = Arrays.stream(mappingClass.getDeclaredConstructors())
                    .filter(c -> c.getParameterCount() == 0)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Could not instantiate mapping "
                            + mappingClass
                            + "; There is no public, no-args constructor present in mapping class ")
                    );

            return (EntityMapper<?>) constructor.newInstance(new Object[]{});
        } catch (InstantiationException e) {
            throw new FluentMapperException("Could not instantiate " + mappingClass + "; mapping class cannot be abstract.", e);
        } catch (InvocationTargetException e) {
            throw new FluentMapperException("Could not instantiate " + mappingClass, e);
        } catch (IllegalAccessException e) {
            throw new FluentMapperException("Could not instantiate " + mappingClass + "; no access to constructor.", e);
        }
    };
    private final MapperConfiguration mapperConfiguration;
    private final TaskExecutor executor;

    public DefaultFluentMapper(MapperConfiguration mapperConfiguration) {
        this.mapperConfiguration = mapperConfiguration;
        this.executor = new TaskExecutor();
        ModelClassLoader.INSTANCE.setClassLoader(this.initializeModelClassLoader());
        logger.debug("FluentMapper initialized.");
    }

    @Override
    public void execute() {
        logger.info("Locating mappings in package {}", mapperConfiguration.mappingsPackage());

        MappingClassFinder classFinder = MappingClassFinder.fromConfig(mapperConfiguration);

        List<Class<? extends EntityMapper<?>>> mappingClasses = classFinder.findMappingClasses(
                mapperConfiguration.mappingsPackage()
        );

        var mappers = mappingClasses.stream()
                .map(toMapper)
                .peek(mapping -> logger.debug("Registered mapping {}", mapping.getClass().getName()))
                .toList();

        var models = this.executor.submitMappings(mappers);

        final String mappings = this.executor.submitModels(models);

        if (this.mapperConfiguration.exports()) {
            this.exportMappings(mappings);
        }

        if (this.mapperConfiguration.pathStrategy().equals("path")) {
            try {
                ((URLClassLoader) ModelClassLoader.INSTANCE.getClassLoader()).close();
            } catch (IOException e) {
                logger.warn("Could not release classloader resources", e);
            }
        }

        this.executor.shutdown();
    }

    /**
     * Initializes the classloader to be used by the {@link ModelClassLoader}, depending on the strategy used for
     * locating the mapping files.
     *
     * @return a classloader capable of loading model classes.
     */
    private ClassLoader initializeModelClassLoader() {
        final String pathStrategy = this.mapperConfiguration.pathStrategy();
        final String classpath = this.mapperConfiguration.mappingsPath();
        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        if (pathStrategy.equals("package")) {
            return contextClassLoader;
        }

        if (classpath.isBlank()) {
            throw new FluentMapperException("Failed to initialize classloader for model classes; invalid classpath given - " + classpath);
        }

        try {
            URL[] urls = new URL[]{URI.create("file:///" + classpath.replace('\\', '/') + "/").toURL()};
            return URLClassLoader.newInstance(urls, contextClassLoader);
        } catch (MalformedURLException e) {
            throw new FluentMapperException("Failed to initialize classloader for model classes; could not convert classpath to URL.", e);
        }
    }

    /**
     * Exports the final generated mappings to the path provided in the configuration.
     * <p>
     * Ideally these would be somehow output in the `resources` folder, but since it's
     * supposed to be read-only, it's best if this file is exported somewhere in the
     * file system.
     */

    private void exportMappings(String mappings) {
        try {
            String[] outputPaths = mapperConfiguration.exportPaths();

            if (outputPaths.length == 0) {
                throw new FluentMapperException("No output path specified.");
            }

            for (String path : outputPaths) {
                Writer fileWriter = new FileWriter(path, false);
                String fluentCredits = "<!-- This file was generated by FluentMapper at "
                        + DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").format(LocalDateTime.now())
                        + " -->";
                String output = mappings.replace(
                        "<entity-mappings",
                        fluentCredits + "\r<entity-mappings");
                fileWriter.write(output);
                fileWriter.close();
            }

            logger.info("Finished outputting mappings - have a nice day!");
        } catch (IOException e) {
            throw new FluentMapperException("Could not output mappings;", e);
        }
    }

}
