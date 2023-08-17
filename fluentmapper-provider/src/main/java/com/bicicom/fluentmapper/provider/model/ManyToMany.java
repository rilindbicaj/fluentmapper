package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "many-to-many", propOrder = {
        "orderBy",
        "orderColumn",
        "mapKey",
        "mapKeyClass",
        "mapKeyTemporal",
        "mapKeyEnumerated",
        "mapKeyAttributeOverride",
        "mapKeyColumn",
        "mapKeyJoinColumn",
        "joinTable",
        "cascade"
})
public class ManyToMany {

    @XmlElement(name = "order-by")
    protected String orderBy;
    @XmlElement(name = "order-column")
    protected OrderColumn orderColumn;
    @XmlElement(name = "map-key")
    protected MapKey mapKey;
    @XmlElement(name = "map-key-class")
    protected MapKeyClass mapKeyClass;
    @XmlElement(name = "map-key-temporal")
    @XmlSchemaType(name = "token")
    protected TemporalType mapKeyTemporal;
    @XmlElement(name = "map-key-enumerated")
    @XmlSchemaType(name = "token")
    protected EnumType mapKeyEnumerated;
    @XmlElement(name = "map-key-attribute-override")
    protected List<AttributeOverride> mapKeyAttributeOverride;
    @XmlElement(name = "map-key-column")
    protected MapKeyColumn mapKeyColumn;
    @XmlElement(name = "map-key-join-column")
    protected List<MapKeyJoinColumn> mapKeyJoinColumn;
    @XmlElement(name = "join-table")
    protected JoinTable joinTable;
    protected CascadeType cascade;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "target-entity")
    protected String targetEntity;
    @XmlAttribute(name = "fetch")
    protected FetchType fetch;
    @XmlAttribute(name = "access")
    protected AccessType access;
    @XmlAttribute(name = "mapped-by")
    protected String mappedBy;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String value) {
        this.orderBy = value;
    }

    public OrderColumn getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(OrderColumn value) {
        this.orderColumn = value;
    }

    public MapKey getMapKey() {
        return mapKey;
    }

    public void setMapKey(MapKey value) {
        this.mapKey = value;
    }

    public MapKeyClass getMapKeyClass() {
        return mapKeyClass;
    }

    public void setMapKeyClass(MapKeyClass value) {
        this.mapKeyClass = value;
    }

    public TemporalType getMapKeyTemporal() {
        return mapKeyTemporal;
    }

    public void setMapKeyTemporal(TemporalType value) {
        this.mapKeyTemporal = value;
    }

    public EnumType getMapKeyEnumerated() {
        return mapKeyEnumerated;
    }

    public void setMapKeyEnumerated(EnumType value) {
        this.mapKeyEnumerated = value;
    }

    public List<AttributeOverride> getMapKeyAttributeOverride() {
        if (mapKeyAttributeOverride == null) {
            mapKeyAttributeOverride = new ArrayList<AttributeOverride>();
        }
        return this.mapKeyAttributeOverride;
    }

    public MapKeyColumn getMapKeyColumn() {
        return mapKeyColumn;
    }

    public void setMapKeyColumn(MapKeyColumn value) {
        this.mapKeyColumn = value;
    }

    public List<MapKeyJoinColumn> getMapKeyJoinColumn() {
        if (mapKeyJoinColumn == null) {
            mapKeyJoinColumn = new ArrayList<MapKeyJoinColumn>();
        }
        return this.mapKeyJoinColumn;
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

    public AccessType getAccess() {
        return access;
    }

    public void setAccess(AccessType value) {
        this.access = value;
    }

    public String getMappedBy() {
        return mappedBy;
    }

    public void setMappedBy(String value) {
        this.mappedBy = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManyToMany that = (ManyToMany) o;
        return Objects.equals(joinTable, that.joinTable) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(joinTable, name);
    }
}
