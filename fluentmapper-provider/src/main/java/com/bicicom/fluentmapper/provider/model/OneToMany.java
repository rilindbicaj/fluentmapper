package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "one-to-many", propOrder = {
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
        "joinColumn",
        "cascade"
})
public class OneToMany {

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
    @XmlElement(name = "join-column")
    protected List<JoinColumn> joinColumn;
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
    @XmlAttribute(name = "orphan-removal")
    protected Boolean orphanRemoval;

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

    public List<JoinColumn> getJoinColumn() {
        if (joinColumn == null) {
            joinColumn = new ArrayList<JoinColumn>();
        }
        return this.joinColumn;
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

    public Boolean isOrphanRemoval() {
        return orphanRemoval;
    }

    public void setOrphanRemoval(Boolean value) {
        this.orphanRemoval = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OneToMany oneToMany = (OneToMany) o;
        return Objects.equals(joinColumn, oneToMany.joinColumn) && Objects.equals(name, oneToMany.name) && Objects.equals(targetEntity, oneToMany.targetEntity) && Objects.equals(mappedBy, oneToMany.mappedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(joinColumn, name, targetEntity, mappedBy);
    }
}
