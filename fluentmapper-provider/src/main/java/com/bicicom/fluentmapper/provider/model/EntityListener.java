package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entity-listener", propOrder = {
        "description",
        "prePersist",
        "postPersist",
        "preRemove",
        "postRemove",
        "preUpdate",
        "postUpdate",
        "postLoad"
})
public class EntityListener {

    protected String description;
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
    @XmlAttribute(name = "class", required = true)
    protected String clazz;

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
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

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String value) {
        this.clazz = value;
    }

}
