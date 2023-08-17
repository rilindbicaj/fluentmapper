package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "embeddable", propOrder = {
        "description",
        "attributes"
})
public class Embeddable {

    protected String description;
    protected EmbeddableAttributes attributes;
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

    public EmbeddableAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(EmbeddableAttributes value) {
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
