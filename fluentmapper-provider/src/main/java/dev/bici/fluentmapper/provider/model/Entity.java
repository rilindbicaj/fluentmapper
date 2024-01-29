package dev.bici.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entity", propOrder = {
        "table",
        "attributes"
})
public class Entity {

    protected Table table;
    protected Attributes attributes;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "class", required = true)
    protected String clazz;

    public Entity() {
        this.attributes = new Attributes();
    }

    public void setTable(Table value) {
        this.table = value;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setClazz(String value) {
        this.clazz = value;
    }

}
