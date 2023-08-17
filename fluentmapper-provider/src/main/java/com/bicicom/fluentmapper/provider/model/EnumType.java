package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(name = "enum-type")
@XmlEnum
public enum EnumType {

    ORDINAL,
    STRING;

    public static EnumType fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
