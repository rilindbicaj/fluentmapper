package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(name = "fetch-type")
@XmlEnum
public enum FetchType {

    LAZY,
    EAGER;

    public static FetchType fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
