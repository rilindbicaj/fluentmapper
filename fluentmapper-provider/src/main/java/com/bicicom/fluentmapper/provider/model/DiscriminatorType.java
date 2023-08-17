package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(name = "discriminator-type")
@XmlEnum
public enum DiscriminatorType {

    STRING,
    CHAR,
    INTEGER;

    public static DiscriminatorType fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
