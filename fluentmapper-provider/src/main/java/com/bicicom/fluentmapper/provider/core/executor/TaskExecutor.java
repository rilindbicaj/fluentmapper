package com.bicicom.fluentmapper.provider.core.executor;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.provider.model.ReadonlyEntityModel;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public final class TaskExecutor {
    private final ExecutorService executorService;

    public TaskExecutor() {
        // Caching has proved more efficient than concurrency at least for smaller loads
        this.executorService = Executors.newFixedThreadPool(1);
    }

    private static ReadonlyEntityModel tryGetModel(Future<ReadonlyEntityModel> builderTaskFuture) {
        try {
            return builderTaskFuture.get();
        } catch (ExecutionException e) {
            throw new RuntimeException("Should not happen", e);
        } catch (InterruptedException e) {
            throw new RuntimeException("Should not happen either", e);
        }
    }

    public List<ReadonlyEntityModel> executeMappers(List<EntityMapper<?>> mappers) {
        var tasks = mappers.stream()
                .map(ConfigurationBuildingTask::new)
                .toList();
        try {
            return this.executorService.invokeAll(tasks)
                    .stream()
                    .map(TaskExecutor::tryGetModel)
                    .toList();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String parseModels(Collection<ReadonlyEntityModel> entityModels) {
        try {
            return this.executorService.submit(new ConfigurationParsingTask(entityModels)).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void shutdown() {
        try {
            this.executorService.shutdown();
            this.executorService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().stop();
            throw new RuntimeException(e);
        }
    }

}
