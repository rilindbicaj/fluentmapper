package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(name = "temporal-type")
@XmlEnum
public enum TemporalType {

    DATE,
    TIME,
    TIMESTAMP;

    public static TemporalType fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
