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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The default implementation of Fluentmapper.
 */
final class DefaultFluentMapper implements FluentMapper {

    private static final Logger logger = LoggerFactory.getLogger(FluentMapper.class);
    private final MapperConfiguration mapperConfiguration;
    private final TaskExecutor executor;

    public DefaultFluentMapper(MapperConfiguration mapperConfiguration) {
        this.mapperConfiguration = mapperConfiguration;
        this.executor = new TaskExecutor();
        ModelClassLoader.INSTANCE.setClassLoader(this.initializeModelClassLoader());
        logger.debug("FluentMapper initialized.");
    }

    @SuppressWarnings("unchecked")
    private static EntityMapper<?> instantiateMapper(Class<? extends EntityMapper<?>> mappingClass) {
        try {
            Constructor<?> constructor = Arrays.stream(mappingClass.getDeclaredConstructors())
                    .filter(c -> c.getParameterCount() == 0)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Could not instantiate mapping "
                            + mappingClass
                            + "; There is no public, no-args constructor present in mapping class ")
                    );

            return (EntityMapper<?>) constructor.newInstance();
        } catch (InstantiationException e) {
            throw new FluentMapperException("Could not instantiate " + mappingClass + "; mapping class cannot be abstract.", e);
        } catch (InvocationTargetException e) {
            throw new FluentMapperException("Could not instantiate " + mappingClass, e);
        } catch (IllegalAccessException e) {
            throw new FluentMapperException("Could not instantiate " + mappingClass + "; no access to constructor.", e);
        }
    }

    @Override
    public void execute() {
        logger.info("Locating mappings in package {}", mapperConfiguration.mappingsPackage());

        MappingClassFinder classFinder = new MappingClassFinder(ModelClassLoader.INSTANCE.getClassLoader());

        List<Class<? extends EntityMapper<?>>> mappingClasses = classFinder.findMappingClasses(
                mapperConfiguration.mappingsPackage()
        );

        var mapperInstances = mappingClasses.stream()
                .map(DefaultFluentMapper::instantiateMapper)
                .peek(mapping -> logger.debug("Registered mapping {}", mapping.getClass().getName()))
                .toList();

        var models = this.executor.submitMappers(mapperInstances);

        final String mappings = this.executor.submitModels(models);

        this.exportMappings(mappings);

        if (!this.mapperConfiguration.classpath().isBlank()) {
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
        final String classpath = this.mapperConfiguration.classpath();
        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        if (classpath.isBlank()) {
            logger.debug("Classpath is not set - using the context classloader for loading model classes.");
            return contextClassLoader;
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
        List<String> outputPaths = new ArrayList<>();

        final String classpath = mapperConfiguration.classpath();

        if (!classpath.isBlank()) {
            outputPaths.add(classpath + "/META-INF/orm.xml");
        }

        final String[] additionalExportPaths = mapperConfiguration.additionalExportPaths();

        Collections.addAll(outputPaths, additionalExportPaths);

        String fluentCredits = "<!-- This file was generated by FluentMapper at "
                + DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").format(LocalDateTime.now())
                + " -->";
        String output = mappings.replace(
                "<entity-mappings",
                fluentCredits + "\r<entity-mappings");

        outputPaths.forEach(outputPath -> {
            try (Writer writer = new FileWriter(outputPath, false)) {
                writer.write(output);
            } catch (IOException e) {
                throw new FluentMapperException("Could not output mappings;", e);
            }
        });
    }

}
