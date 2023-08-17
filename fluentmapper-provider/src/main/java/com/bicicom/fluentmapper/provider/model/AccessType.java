package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(name = "access-type")
@XmlEnum
public enum AccessType {

    PROPERTY,
    FIELD;

    public static AccessType fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
