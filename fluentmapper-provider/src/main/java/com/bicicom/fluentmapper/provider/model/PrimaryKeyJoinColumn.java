package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "primary-key-join-column")
public class PrimaryKeyJoinColumn {

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "referenced-column-name")
    protected String referencedColumnName;
    @XmlAttribute(name = "column-definition")
    protected String columnDefinition;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getReferencedColumnName() {
        return referencedColumnName;
    }

    public void setReferencedColumnName(String value) {
        this.referencedColumnName = value;
    }

    public String getColumnDefinition() {
        return columnDefinition;
    }

    public void setColumnDefinition(String value) {
        this.columnDefinition = value;
    }

}
