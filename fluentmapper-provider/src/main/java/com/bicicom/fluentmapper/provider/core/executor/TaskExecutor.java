package com.bicicom.fluentmapper.provider.core.executor;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.provider.core.exception.FluentMapperExecutionException;
import com.bicicom.fluentmapper.provider.model.Entity;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public final class TaskExecutor {

    private final ExecutorService executorService;

    public TaskExecutor() {
        // TODO - check if a more CPU intensive, less reflection based solution can leverage the concurrent structure
        // Caching has proved more efficient than concurrency at least for smaller loads. Also, because most of the
        // bottleneck regarding JAXB is its initialization time, adding more threads is not gonna affect throughput
        this.executorService = Executors.newVirtualThreadPerTaskExecutor();
    }

    private static Entity tryGetModel(Future<Entity> builderTaskFuture) {
        try {
            return builderTaskFuture.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new FluentMapperExecutionException("Entity model configuration failed before it could be completed.", e);
        }
    }

    private static String tryGetParsedMappings(Future<String> parsingTaskFuture) {
        try {
            return parsingTaskFuture.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new FluentMapperExecutionException(
                    "Failed to get parsed entity model; the parsing task failed before it could be finished.", e);
        }
    }

    /**
     * Executes the mapping classes provided and configures the entity models according
     * to their contents.
     *
     * @param mappers instances of {@link EntityMapper} which were defined by the user
     * @return a list of {@link Entity} instances with fields set according to the provided mappers
     */
    public List<Entity> submitMappers(Collection<? extends EntityMapper<?>> mappers) {
        var tasks = mappers.stream()
                .map(ConfigurationBuildingTask::new)
                .toList();
        try {
            return this.executorService.invokeAll(tasks)
                    .stream()
                    .map(TaskExecutor::tryGetModel)
                    .toList();
        } catch (InterruptedException e) {
            throw new FluentMapperExecutionException("Failed building entity models.", e);
        }
    }

    /**
     * Creates and executes {@link ConfigurationParsingTask} from the submitted entity models.
     *
     * @param entityModels a {@link Collection} of {@link Entity} instances with which to configure the parsing tasks
     * @return the XML containing the joined output of all tasks.
     */
    public String submitModels(Collection<Entity> entityModels) {
        try {
            var task = new ConfigurationParsingTask(entityModels);

            // TODO - check if this is actually concurrent
            return this.executorService.invokeAll(List.of(task))
                    .stream()
                    .map(TaskExecutor::tryGetParsedMappings)
                    .reduce("", String::concat);
        } catch (RejectedExecutionException | InterruptedException e) {
            throw new FluentMapperExecutionException("Could not parse entity models;", e);
        }
    }

    // Check for correctness
    public void shutdown() {
        try {
            this.executorService.shutdown();
            this.executorService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new FluentMapperExecutionException("Could not shut down task executor;", e);
        }
    }

}
