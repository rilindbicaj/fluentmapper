package com.bicicom.fluentmapper.expression;

import java.io.Serializable;
import java.util.function.Function;

@FunctionalInterface
public interface Expression<S,T> extends Function<S,T>, Serializable {
}
