package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attribute-override", propOrder = {
        "description",
        "column"
})
public class AttributeOverride {

    protected String description;
    @XmlElement(required = true)
    protected Column column;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column value) {
        this.column = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

}
