package com.bicicom.fluentmapper.provider.expression.parser;

public class ExpressionParseException extends RuntimeException {

    public ExpressionParseException(String message) {
        super(message);
    }

    public ExpressionParseException(String message, Throwable cause) {
        super(message, cause);
    }

}
