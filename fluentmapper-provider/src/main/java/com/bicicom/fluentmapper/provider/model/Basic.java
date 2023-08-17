package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "basic", propOrder = {
        "column",
        "lob",
        "temporal",
        "enumerated"
})
public class Basic {

    protected Column column;
    protected Lob lob;
    @XmlSchemaType(name = "token")
    protected TemporalType temporal;
    @XmlSchemaType(name = "token")
    protected EnumType enumerated;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "fetch")
    protected FetchType fetch;
    @XmlAttribute(name = "optional")
    protected Boolean optional;
    @XmlAttribute(name = "access")
    protected AccessType access;

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column value) {
        this.column = value;
    }

    public Lob getLob() {
        return lob;
    }

    public void setLob(Lob value) {
        this.lob = value;
    }

    public TemporalType getTemporal() {
        return temporal;
    }

    public void setTemporal(TemporalType value) {
        this.temporal = value;
    }

    public EnumType getEnumerated() {
        return enumerated;
    }

    public void setEnumerated(EnumType value) {
        this.enumerated = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public FetchType getFetch() {
        return fetch;
    }

    public void setFetch(FetchType value) {
        this.fetch = value;
    }

    public Boolean isOptional() {
        return optional;
    }

    public void setOptional(Boolean value) {
        this.optional = value;
    }

    public AccessType getAccess() {
        return access;
    }

    public void setAccess(AccessType value) {
        this.access = value;
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
