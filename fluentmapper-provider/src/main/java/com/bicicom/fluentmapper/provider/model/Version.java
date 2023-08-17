package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "version", propOrder = {
        "column",
        "temporal"
})
public class Version {

    protected Column column;
    @XmlSchemaType(name = "token")
    protected TemporalType temporal;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "access")
    protected AccessType access;

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column value) {
        this.column = value;
    }

    public TemporalType getTemporal() {
        return temporal;
    }

    public void setTemporal(TemporalType value) {
        this.temporal = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public AccessType getAccess() {
        return access;
    }

    public void setAccess(AccessType value) {
        this.access = value;
    }

}
