package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(name = "lock-mode-type")
@XmlEnum
public enum LockModeType {

    READ,
    WRITE,
    OPTIMISTIC,
    OPTIMISTIC_FORCE_INCREMENT,
    PESSIMISTIC_READ,
    PESSIMISTIC_WRITE,
    PESSIMISTIC_FORCE_INCREMENT,
    NONE;

    public static LockModeType fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
