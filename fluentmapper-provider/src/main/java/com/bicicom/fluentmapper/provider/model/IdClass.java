package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "id-class")
public class IdClass {

    @XmlAttribute(name = "class", required = true)
    protected String clazz;

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String value) {
        this.clazz = value;
    }

}
