package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "embedded", propOrder = {
        "attributeOverride",
        "associationOverride"
})
public class Embedded {

    @XmlElement(name = "attribute-override")
    protected List<AttributeOverride> attributeOverride;
    @XmlElement(name = "association-override")
    protected List<AssociationOverride> associationOverride;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "access")
    protected AccessType access;

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

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public AccessType getAccess() {
        return access;
    }

    public void setAccess(AccessType value) {
        this.access = value;
    }

}
