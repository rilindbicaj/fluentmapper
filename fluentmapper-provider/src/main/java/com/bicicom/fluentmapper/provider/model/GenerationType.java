package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(name = "generation-type")
@XmlEnum
public enum GenerationType {

    TABLE,
    SEQUENCE,
    IDENTITY,
    AUTO;

    public static GenerationType fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
