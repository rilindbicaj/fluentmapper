package dev.bici.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "table")
public class Table {

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "catalog")
    protected String catalog;
    @XmlAttribute(name = "schema")
    protected String schema;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setCatalog(String value) {
        this.catalog = value;
    }

    public void setSchema(String value) {
        this.schema = value;
    }

}
