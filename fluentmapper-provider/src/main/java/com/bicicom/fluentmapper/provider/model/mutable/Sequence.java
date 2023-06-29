package com.bicicom.fluentmapper.provider.model.mutable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Affects the sequence in which fields appear in the final XML file. Unfortunately necessary.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Sequence {
    int value();
}
