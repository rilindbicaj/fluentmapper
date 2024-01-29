package dev.bici.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "many-to-many", propOrder = {
        "joinTable",
})
public class ManyToMany {

    @XmlElement(name = "join-table")
    protected JoinTable joinTable;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "target-entity")
    protected String targetEntity;

    @XmlAttribute(name = "mapped-by")
    protected String mappedBy;

    public void setJoinTable(JoinTable value) {
        this.joinTable = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setTargetEntity(String value) {
        this.targetEntity = value;
    }

    public void setMappedBy(String value) {
        this.mappedBy = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManyToMany that = (ManyToMany) o;
        return Objects.equals(joinTable, that.joinTable) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(joinTable, name);
    }
}
