package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sequence-generator", propOrder = {
        "description"
})
public class SequenceGenerator {

    protected String description;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "sequence-name")
    protected String sequenceName;
    @XmlAttribute(name = "catalog")
    protected String catalog;
    @XmlAttribute(name = "schema")
    protected String schema;
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

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getSequenceName() {
        return sequenceName;
    }

    public void setSequenceName(String value) {
        this.sequenceName = value;
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
