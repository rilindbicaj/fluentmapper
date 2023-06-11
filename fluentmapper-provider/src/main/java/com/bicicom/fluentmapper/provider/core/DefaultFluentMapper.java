package com.bicicom.fluentmapper.provider.core;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.core.FluentMapper;
import com.bicicom.fluentmapper.core.config.MapperConfiguration;
import com.bicicom.fluentmapper.provider.core.executor.TaskExecutor;
import com.bicicom.fluentmapper.provider.core.executor.classfinder.EntityClassFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
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
        logger.info("Locating mappings in package {}", mapperConfiguration.mappingsLocation());
        var mappers = this.findAllEntityClasses().stream()
                .map(toMapper)
                .peek(mapping -> logger.debug("Registered mapping {}", mapping.getClass().getName()))
                .toList();

        logger.info("Located mappings {}", mappers.stream().map(entityMapper -> entityMapper.getClass().getSimpleName()).toList());
        var models = this.executor.executeMappers(mappers);

        this.mappings = this.executor.parseModels(models);

        if (this.mapperConfiguration.exports()) {
            try {
                String outputPath = mapperConfiguration.exportPath();
                FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
                fileOutputStream.write(getMappings().getBytes());
                fileOutputStream.close();
                logger.info("Finished outputting mappings - have a nice day!");
            } catch (IOException e) {
                throw new FluentMapperException("Could not output mappings;", e);
            }
        }

        this.executor.shutdown();
    }

    public String getMappings() {
        return this.mappings;
    }

    private List<Class<? extends EntityMapper<?>>> findAllEntityClasses() {
        try {
            return EntityClassFinder.getClasses(
                    mapperConfiguration.mappingsLocation()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
