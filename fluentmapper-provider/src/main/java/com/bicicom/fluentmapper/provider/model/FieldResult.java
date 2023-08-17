package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "field-result")
public class FieldResult {

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "column", required = true)
    protected String column;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String value) {
        this.column = value;
    }

}
