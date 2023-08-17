package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(name = "inheritance-type")
@XmlEnum
public enum InheritanceType {

    SINGLE_TABLE,
    JOINED,
    TABLE_PER_CLASS;

    public static InheritanceType fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
