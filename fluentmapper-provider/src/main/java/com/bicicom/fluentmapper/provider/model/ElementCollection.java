package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "element-collection", propOrder = {
        "orderBy",
        "orderColumn",
        "mapKey",
        "mapKeyClass",
        "mapKeyTemporal",
        "mapKeyEnumerated",
        "mapKeyAttributeOverride",
        "mapKeyColumn",
        "mapKeyJoinColumn",
        "column",
        "temporal",
        "enumerated",
        "lob",
        "attributeOverride",
        "associationOverride",
        "collectionTable"
})
public class ElementCollection {

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
    protected Column column;
    @XmlSchemaType(name = "token")
    protected TemporalType temporal;
    @XmlSchemaType(name = "token")
    protected EnumType enumerated;
    protected Lob lob;
    @XmlElement(name = "attribute-override")
    protected List<AttributeOverride> attributeOverride;
    @XmlElement(name = "association-override")
    protected List<AssociationOverride> associationOverride;
    @XmlElement(name = "collection-table")
    protected CollectionTable collectionTable;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "target-class")
    protected String targetClass;
    @XmlAttribute(name = "fetch")
    protected FetchType fetch;
    @XmlAttribute(name = "access")
    protected AccessType access;

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

    public EnumType getEnumerated() {
        return enumerated;
    }

    public void setEnumerated(EnumType value) {
        this.enumerated = value;
    }

    public Lob getLob() {
        return lob;
    }

    public void setLob(Lob value) {
        this.lob = value;
    }

    public List<AttributeOverride> getAttributeOverride() {
        if (attributeOverride == null) {
            attributeOverride = new ArrayList<AttributeOverride>();
        }
        return this.attributeOverride;
    }

    public List<AssociationOverride> getAssociationOverride() {
        if (associationOverride == null) {
            associationOverride = new ArrayList<AssociationOverride>();
        }
        return this.associationOverride;
    }

    public CollectionTable getCollectionTable() {
        return collectionTable;
    }

    public void setCollectionTable(CollectionTable value) {
        this.collectionTable = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(String value) {
        this.targetClass = value;
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

}
