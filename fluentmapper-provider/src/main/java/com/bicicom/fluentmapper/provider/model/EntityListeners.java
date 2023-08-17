package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entity-listeners", propOrder = {
        "entityListener"
})
public class EntityListeners {

    @XmlElement(name = "entity-listener")
    protected List<EntityListener> entityListener;

    public List<EntityListener> getEntityListener() {
        if (entityListener == null) {
            entityListener = new ArrayList<EntityListener>();
        }
        return this.entityListener;
    }

}
