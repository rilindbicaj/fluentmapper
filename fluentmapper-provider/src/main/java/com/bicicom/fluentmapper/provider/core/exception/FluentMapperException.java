package com.bicicom.fluentmapper.provider.core.exception;

/**
 * General exception.
 */
public class FluentMapperException extends RuntimeException {

    public FluentMapperException(String message) {
        super(message);
    }

    public FluentMapperException(String message, Throwable cause) {
        super(message, cause);
    }

}
