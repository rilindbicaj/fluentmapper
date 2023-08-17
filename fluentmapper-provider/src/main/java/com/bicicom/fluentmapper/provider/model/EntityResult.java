package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entity-result", propOrder = {
        "fieldResult"
})
public class EntityResult {

    @XmlElement(name = "field-result")
    protected List<FieldResult> fieldResult;
    @XmlAttribute(name = "entity-class", required = true)
    protected String entityClass;
    @XmlAttribute(name = "discriminator-column")
    protected String discriminatorColumn;

    public List<FieldResult> getFieldResult() {
        if (fieldResult == null) {
            fieldResult = new ArrayList<FieldResult>();
        }
        return this.fieldResult;
    }

    public String getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(String value) {
        this.entityClass = value;
    }

    public String getDiscriminatorColumn() {
        return discriminatorColumn;
    }

    public void setDiscriminatorColumn(String value) {
        this.discriminatorColumn = value;
    }

}
