package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mapped-superclass", propOrder = {
        "description",
        "idClass",
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
        "attributes"
})
public class MappedSuperclass {

    protected String description;
    @XmlElement(name = "id-class")
    protected IdClass idClass;
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
    protected Attributes attributes;
    @XmlAttribute(name = "class", required = true)
    protected String clazz;
    @XmlAttribute(name = "access")
    protected AccessType access;
    @XmlAttribute(name = "metadata-complete")
    protected Boolean metadataComplete;

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public IdClass getIdClass() {
        return idClass;
    }

    public void setIdClass(IdClass value) {
        this.idClass = value;
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

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes value) {
        this.attributes = value;
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

    public Boolean isMetadataComplete() {
        return metadataComplete;
    }

    public void setMetadataComplete(Boolean value) {
        this.metadataComplete = value;
    }

}
