package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "many-to-one", propOrder = {
        "joinColumn",
        "joinTable",
        "cascade"
})
public class ManyToOne {

    @XmlElement(name = "join-column")
    protected List<JoinColumn> joinColumn;
    @XmlElement(name = "join-table")
    protected JoinTable joinTable;
    protected CascadeType cascade;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "target-entity")
    protected String targetEntity;
    @XmlAttribute(name = "fetch")
    protected FetchType fetch;
    @XmlAttribute(name = "optional")
    protected Boolean optional;
    @XmlAttribute(name = "access")
    protected AccessType access;
    @XmlAttribute(name = "maps-id")
    protected String mapsId;
    @XmlAttribute(name = "id")
    protected Boolean id;

    public List<JoinColumn> getJoinColumn() {
        if (joinColumn == null) {
            joinColumn = new ArrayList<JoinColumn>();
        }
        return this.joinColumn;
    }

    public JoinTable getJoinTable() {
        return joinTable;
    }

    public void setJoinTable(JoinTable value) {
        this.joinTable = value;
    }

    public CascadeType getCascade() {
        return cascade;
    }

    public void setCascade(CascadeType value) {
        this.cascade = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getTargetEntity() {
        return targetEntity;
    }

    public void setTargetEntity(String value) {
        this.targetEntity = value;
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

    public String getMapsId() {
        return mapsId;
    }

    public void setMapsId(String value) {
        this.mapsId = value;
    }

    public Boolean isId() {
        return id;
    }

    public void setId(Boolean value) {
        this.id = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManyToOne manyToOne = (ManyToOne) o;
        return Objects.equals(joinColumn, manyToOne.joinColumn) && Objects.equals(name, manyToOne.name) && Objects.equals(targetEntity, manyToOne.targetEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(joinColumn, name, targetEntity);
    }
}
