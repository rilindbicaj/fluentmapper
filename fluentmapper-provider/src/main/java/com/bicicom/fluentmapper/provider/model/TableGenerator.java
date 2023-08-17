package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "table-generator", propOrder = {
        "description",
        "uniqueConstraint"
})
public class TableGenerator {

    protected String description;
    @XmlElement(name = "unique-constraint")
    protected List<UniqueConstraint> uniqueConstraint;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "table")
    protected String table;
    @XmlAttribute(name = "catalog")
    protected String catalog;
    @XmlAttribute(name = "schema")
    protected String schema;
    @XmlAttribute(name = "pk-column-name")
    protected String pkColumnName;
    @XmlAttribute(name = "value-column-name")
    protected String valueColumnName;
    @XmlAttribute(name = "pk-column-value")
    protected String pkColumnValue;
    @XmlAttribute(name = "initial-value")
    protected Integer initialValue;
    @XmlAttribute(name = "allocation-size")
    protected Integer allocationSize;

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public List<UniqueConstraint> getUniqueConstraint() {
        if (uniqueConstraint == null) {
            uniqueConstraint = new ArrayList<UniqueConstraint>();
        }
        return this.uniqueConstraint;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String value) {
        this.table = value;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String value) {
        this.catalog = value;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String value) {
        this.schema = value;
    }

    public String getPkColumnName() {
        return pkColumnName;
    }

    public void setPkColumnName(String value) {
        this.pkColumnName = value;
    }

    public String getValueColumnName() {
        return valueColumnName;
    }

    public void setValueColumnName(String value) {
        this.valueColumnName = value;
    }

    public String getPkColumnValue() {
        return pkColumnValue;
    }

    public void setPkColumnValue(String value) {
        this.pkColumnValue = value;
    }

    public Integer getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Integer value) {
        this.initialValue = value;
    }

    public Integer getAllocationSize() {
        return allocationSize;
    }

    public void setAllocationSize(Integer value) {
        this.allocationSize = value;
    }

}
