package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "basic", propOrder = {
        "column"
})
public class Basic {

    protected Column column;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "optional")
    protected Boolean optional;

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column value) {
        this.column = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setOptional(Boolean value) {
        this.optional = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basic basic = (Basic) o;
        return Objects.equals(name, basic.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
