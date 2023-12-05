package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "column")
public class Column {

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "unique")
    protected Boolean unique;
    @XmlAttribute(name = "nullable")
    protected Boolean nullable;
    @XmlAttribute(name = "length")
    protected Integer length;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setUnique(Boolean value) {
        this.unique = value;
    }

    public void setNullable(Boolean value) {
        this.nullable = value;
    }

    public void setLength(Integer value) {
        this.length = value;
    }

}
