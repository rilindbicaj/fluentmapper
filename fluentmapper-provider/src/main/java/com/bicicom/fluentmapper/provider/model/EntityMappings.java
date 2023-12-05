package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "entity",
})
@XmlRootElement(name = "entity-mappings")
public class EntityMappings {

    protected List<Entity> entity;
    @XmlAttribute(name = "version", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String version;

    public List<Entity> getEntity() {
        if (entity == null) {
            entity = new ArrayList<Entity>();
        }
        return this.entity;
    }

    public void setVersion(String value) {
        this.version = value;
    }

}
