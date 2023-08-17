package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "map-key-column")
public class MapKeyColumn {

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "unique")
    protected Boolean unique;
    @XmlAttribute(name = "nullable")
    protected Boolean nullable;
    @XmlAttribute(name = "insertable")
    protected Boolean insertable;
    @XmlAttribute(name = "updatable")
    protected Boolean updatable;
    @XmlAttribute(name = "column-definition")
    protected String columnDefinition;
    @XmlAttribute(name = "table")
    protected String table;
    @XmlAttribute(name = "length")
    protected Integer length;
    @XmlAttribute(name = "precision")
    protected Integer precision;
    @XmlAttribute(name = "scale")
    protected Integer scale;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Boolean isUnique() {
        return unique;
    }

    public void setUnique(Boolean value) {
        this.unique = value;
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

    public String getTable() {
        return table;
    }

    public void setTable(String value) {
        this.table = value;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer value) {
        this.length = value;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer value) {
        this.precision = value;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer value) {
        this.scale = value;
    }

}
