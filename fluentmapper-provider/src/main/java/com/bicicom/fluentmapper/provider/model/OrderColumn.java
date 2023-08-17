package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "order-column")
public class OrderColumn {

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "nullable")
    protected Boolean nullable;
    @XmlAttribute(name = "insertable")
    protected Boolean insertable;
    @XmlAttribute(name = "updatable")
    protected Boolean updatable;
    @XmlAttribute(name = "column-definition")
    protected String columnDefinition;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Boolean isNullable() {
        return nullable;
    }

    public void setNullable(Boolean value) {
        this.nullable = value;
    }

    public Boolean isInsertable() {
        return insertable;
    }

    public void setInsertable(Boolean value) {
        this.insertable = value;
    }

    public Boolean isUpdatable() {
        return updatable;
    }

    public void setUpdatable(Boolean value) {
        this.updatable = value;
    }

    public String getColumnDefinition() {
        return columnDefinition;
    }

    public void setColumnDefinition(String value) {
        this.columnDefinition = value;
    }

}
