package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "join-table", propOrder = {
        "joinColumn",
        "inverseJoinColumn",
        "uniqueConstraint"
})
public class JoinTable {

    @XmlElement(name = "join-column")
    protected List<JoinColumn> joinColumn;
    @XmlElement(name = "inverse-join-column")
    protected List<JoinColumn> inverseJoinColumn;
    @XmlElement(name = "unique-constraint")
    protected List<UniqueConstraint> uniqueConstraint;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "catalog")
    protected String catalog;
    @XmlAttribute(name = "schema")
    protected String schema;

    public List<JoinColumn> getJoinColumn() {
        if (joinColumn == null) {
            joinColumn = new ArrayList<JoinColumn>();
        }
        return this.joinColumn;
    }

    public List<JoinColumn> getInverseJoinColumn() {
        if (inverseJoinColumn == null) {
            inverseJoinColumn = new ArrayList<JoinColumn>();
        }
        return this.inverseJoinColumn;
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
