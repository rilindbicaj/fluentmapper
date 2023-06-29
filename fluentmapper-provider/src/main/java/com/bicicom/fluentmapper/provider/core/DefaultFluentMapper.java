package com.bicicom.fluentmapper.provider.core;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.core.FluentMapper;
import com.bicicom.fluentmapper.core.config.MapperConfiguration;
import com.bicicom.fluentmapper.provider.core.executor.TaskExecutor;
import com.bicicom.fluentmapper.provider.core.executor.classfinder.EntityClassFinder;
import com.bicicom.fluentmapper.provider.core.executor.classfinder.URLClassFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public final class DefaultFluentMapper implements FluentMapper {

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
    private String mappings = "";

    DefaultFluentMapper(MapperConfiguration mapperConfiguration) {
        this.mapperConfiguration = mapperConfiguration;
        this.executor = new TaskExecutor();
        logger.debug("FluentMapper initialized");
    }

    @Override
    public void execute() {
        logger.info("Locating mappings in package {}", mapperConfiguration.mappingsPackage());

        List<Class<? extends EntityMapper<?>>> mappingClasses =
                mapperConfiguration.pathStrategy().equals("path") ?
                        this.findEntityClassesFromPath() : this.findAllEntityClassesFromPackage();

        var mappers = mappingClasses.stream()
                .map(toMapper)
                .peek(mapping -> logger.debug("Registered mapping {}", mapping.getClass().getName()))
                .toList();

        logger.info("Located mappings {}", mappers.stream().map(entityMapper -> entityMapper.getClass().getSimpleName()).toList());
        var models = this.executor.executeMappers(mappers);

        this.mappings = this.executor.parseModels(models);

        if (this.mapperConfiguration.exports()) {
            this.exportMappings();
        }

        this.executor.shutdown();
    }

    public String getMappings() {
        return this.mappings;
    }

    private List<Class<? extends EntityMapper<?>>> findAllEntityClassesFromPackage() {
        try {
            return EntityClassFinder.getClasses(
                    mapperConfiguration.mappingsPackage()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Class<? extends EntityMapper<?>>> findEntityClassesFromPath() {
        try {
            return new URLClassFinder().findMappingClasses(
                    mapperConfiguration.mappingsPath(),
                    mapperConfiguration.mappingsPackage()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Exports the final generated mappings to the path provided in the configuration.
     * <p>
     * Ideally these would be somehow output in the `resources` folder, but since it's
     * supposed to be read-only, it's best if this file is exported somewhere in the
     * file system.
     */

    private void exportMappings() {
        try {
            String[] outputPaths = mapperConfiguration.exportPaths();

            if (outputPaths.length == 0) {
                throw new FluentMapperException("No output path specified.");
            }

            for (String path : outputPaths) {
                Writer fileWriter = new FileWriter(path, false);
                fileWriter.write(this.getMappings());
                fileWriter.close();
            }

            logger.info("Finished outputting mappings - have a nice day!");
        } catch (IOException e) {
            throw new FluentMapperException("Could not output mappings;", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
