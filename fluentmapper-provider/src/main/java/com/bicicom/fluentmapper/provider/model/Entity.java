package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entity", propOrder = {
        "description",
        "table",
        "secondaryTable",
        "primaryKeyJoinColumn",
        "idClass",
        "inheritance",
        "discriminatorValue",
        "discriminatorColumn",
        "sequenceGenerator",
        "tableGenerator",
        "namedQuery",
        "namedNativeQuery",
        "sqlResultSetMapping",
        "excludeDefaultListeners",
        "excludeSuperclassListeners",
        "entityListeners",
        "prePersist",
        "postPersist",
        "preRemove",
        "postRemove",
        "preUpdate",
        "postUpdate",
        "postLoad",
        "attributeOverride",
        "associationOverride",
        "attributes"
})
public class Entity {

    protected String description;
    protected Table table;
    @XmlElement(name = "secondary-table")
    protected List<SecondaryTable> secondaryTable;
    @XmlElement(name = "primary-key-join-column")
    protected List<PrimaryKeyJoinColumn> primaryKeyJoinColumn;
    @XmlElement(name = "id-class")
    protected IdClass idClass;
    protected Inheritance inheritance;
    @XmlElement(name = "discriminator-value")
    protected String discriminatorValue;
    @XmlElement(name = "discriminator-column")
    protected DiscriminatorColumn discriminatorColumn;
    @XmlElement(name = "sequence-generator")
    protected SequenceGenerator sequenceGenerator;
    @XmlElement(name = "table-generator")
    protected TableGenerator tableGenerator;
    @XmlElement(name = "named-query")
    protected List<NamedQuery> namedQuery;
    @XmlElement(name = "named-native-query")
    protected List<NamedNativeQuery> namedNativeQuery;
    @XmlElement(name = "sql-result-set-mapping")
    protected List<SqlResultSetMapping> sqlResultSetMapping;
    @XmlElement(name = "exclude-default-listeners")
    protected EmptyType excludeDefaultListeners;
    @XmlElement(name = "exclude-superclass-listeners")
    protected EmptyType excludeSuperclassListeners;
    @XmlElement(name = "entity-listeners")
    protected EntityListeners entityListeners;
    @XmlElement(name = "pre-persist")
    protected PrePersist prePersist;
    @XmlElement(name = "post-persist")
    protected PostPersist postPersist;
    @XmlElement(name = "pre-remove")
    protected PreRemove preRemove;
    @XmlElement(name = "post-remove")
    protected PostRemove postRemove;
    @XmlElement(name = "pre-update")
    protected PreUpdate preUpdate;
    @XmlElement(name = "post-update")
    protected PostUpdate postUpdate;
    @XmlElement(name = "post-load")
    protected PostLoad postLoad;
    @XmlElement(name = "attribute-override")
    protected List<AttributeOverride> attributeOverride;
    @XmlElement(name = "association-override")
    protected List<AssociationOverride> associationOverride;
    protected Attributes attributes;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "class", required = true)
    protected String clazz;
    @XmlAttribute(name = "access")
    protected AccessType access;
    @XmlAttribute(name = "cacheable")
    protected Boolean cacheable;
    @XmlAttribute(name = "metadata-complete")
    protected Boolean metadataComplete;

    public Entity() {
        this.attributes = new Attributes();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table value) {
        this.table = value;
    }

    public List<SecondaryTable> getSecondaryTable() {
        if (secondaryTable == null) {
            secondaryTable = new ArrayList<SecondaryTable>();
        }
        return this.secondaryTable;
    }

    public List<PrimaryKeyJoinColumn> getPrimaryKeyJoinColumn() {
        if (primaryKeyJoinColumn == null) {
            primaryKeyJoinColumn = new ArrayList<PrimaryKeyJoinColumn>();
        }
        return this.primaryKeyJoinColumn;
    }

    public IdClass getIdClass() {
        return idClass;
    }

    public void setIdClass(IdClass value) {
        this.idClass = value;
    }

    public Inheritance getInheritance() {
        return inheritance;
    }

    public void setInheritance(Inheritance value) {
        this.inheritance = value;
    }

    public String getDiscriminatorValue() {
        return discriminatorValue;
    }

    public void setDiscriminatorValue(String value) {
        this.discriminatorValue = value;
    }

    public DiscriminatorColumn getDiscriminatorColumn() {
        return discriminatorColumn;
    }

    public void setDiscriminatorColumn(DiscriminatorColumn value) {
        this.discriminatorColumn = value;
    }

    public SequenceGenerator getSequenceGenerator() {
        return sequenceGenerator;
    }

    public void setSequenceGenerator(SequenceGenerator value) {
        this.sequenceGenerator = value;
    }

    public TableGenerator getTableGenerator() {
        return tableGenerator;
    }

    public void setTableGenerator(TableGenerator value) {
        this.tableGenerator = value;
    }

    public List<NamedQuery> getNamedQuery() {
        if (namedQuery == null) {
            namedQuery = new ArrayList<NamedQuery>();
        }
        return this.namedQuery;
    }

    public List<NamedNativeQuery> getNamedNativeQuery() {
        if (namedNativeQuery == null) {
            namedNativeQuery = new ArrayList<NamedNativeQuery>();
        }
        return this.namedNativeQuery;
    }

    public List<SqlResultSetMapping> getSqlResultSetMapping() {
        if (sqlResultSetMapping == null) {
            sqlResultSetMapping = new ArrayList<SqlResultSetMapping>();
        }
        return this.sqlResultSetMapping;
    }

    public EmptyType getExcludeDefaultListeners() {
        return excludeDefaultListeners;
    }

    public void setExcludeDefaultListeners(EmptyType value) {
        this.excludeDefaultListeners = value;
    }

    public EmptyType getExcludeSuperclassListeners() {
        return excludeSuperclassListeners;
    }

    public void setExcludeSuperclassListeners(EmptyType value) {
        this.excludeSuperclassListeners = value;
    }

    public EntityListeners getEntityListeners() {
        return entityListeners;
    }

    public void setEntityListeners(EntityListeners value) {
        this.entityListeners = value;
    }

    public PrePersist getPrePersist() {
        return prePersist;
    }

    public void setPrePersist(PrePersist value) {
        this.prePersist = value;
    }

    public PostPersist getPostPersist() {
        return postPersist;
    }

    public void setPostPersist(PostPersist value) {
        this.postPersist = value;
    }

    public PreRemove getPreRemove() {
        return preRemove;
    }

    public void setPreRemove(PreRemove value) {
        this.preRemove = value;
    }

    public PostRemove getPostRemove() {
        return postRemove;
    }

    public void setPostRemove(PostRemove value) {
        this.postRemove = value;
    }

    public PreUpdate getPreUpdate() {
        return preUpdate;
    }

    public void setPreUpdate(PreUpdate value) {
        this.preUpdate = value;
    }

    public PostUpdate getPostUpdate() {
        return postUpdate;
    }

    public void setPostUpdate(PostUpdate value) {
        this.postUpdate = value;
    }

    public PostLoad getPostLoad() {
        return postLoad;
    }

    public void setPostLoad(PostLoad value) {
        this.postLoad = value;
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

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes value) {
        this.attributes = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String value) {
        this.clazz = value;
    }

    public AccessType getAccess() {
        return access;
    }

    public void setAccess(AccessType value) {
        this.access = value;
    }

    public Boolean isCacheable() {
        return cacheable;
    }

    public void setCacheable(Boolean value) {
        this.cacheable = value;
    }

    public Boolean isMetadataComplete() {
        return metadataComplete;
    }

    public void setMetadataComplete(Boolean value) {
        this.metadataComplete = value;
    }

}
