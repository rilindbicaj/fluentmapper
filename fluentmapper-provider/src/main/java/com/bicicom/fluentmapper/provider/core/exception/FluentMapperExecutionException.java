package com.bicicom.fluentmapper.provider.core.exception;

/**
 * Exception thrown when FluentMapper tasks have failed.
 */
public class FluentMapperExecutionException extends RuntimeException {

    public FluentMapperExecutionException(String message) {
        super(message);
    }

    public FluentMapperExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

}
