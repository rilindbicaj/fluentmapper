package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "id", propOrder = {
        "column",
})
public class Id {

    protected Column column;

    @XmlAttribute(name = "name", required = true)
    protected String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id id = (Id) o;
        return Objects.equals(name, id.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
