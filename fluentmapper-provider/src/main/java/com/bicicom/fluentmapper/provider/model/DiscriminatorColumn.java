package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "discriminator-column")
public class DiscriminatorColumn {

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "discriminator-type")
    protected DiscriminatorType discriminatorType;
    @XmlAttribute(name = "column-definition")
    protected String columnDefinition;
    @XmlAttribute(name = "length")
    protected Integer length;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public DiscriminatorType getDiscriminatorType() {
        return discriminatorType;
    }

    public void setDiscriminatorType(DiscriminatorType value) {
        this.discriminatorType = value;
    }

    public String getColumnDefinition() {
        return columnDefinition;
    }

    public void setColumnDefinition(String value) {
        this.columnDefinition = value;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer value) {
        this.length = value;
    }

}
