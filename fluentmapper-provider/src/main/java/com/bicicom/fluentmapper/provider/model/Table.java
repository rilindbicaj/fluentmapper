package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "table", propOrder = {
        "uniqueConstraint"
})
public class Table {

    @XmlElement(name = "unique-constraint")
    protected List<UniqueConstraint> uniqueConstraint;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "catalog")
    protected String catalog;
    @XmlAttribute(name = "schema")
    protected String schema;

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

}
