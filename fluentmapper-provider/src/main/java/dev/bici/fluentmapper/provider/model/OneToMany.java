package dev.bici.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "one-to-many", propOrder = {
        "joinColumn",
})
public class OneToMany {

    @XmlElement(name = "join-column")
    protected List<JoinColumn> joinColumn;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "target-entity")
    protected String targetEntity;
    @XmlAttribute(name = "mapped-by")
    protected String mappedBy;

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
        OneToMany oneToMany = (OneToMany) o;
        return Objects.equals(joinColumn, oneToMany.joinColumn) && Objects.equals(name, oneToMany.name) && Objects.equals(targetEntity, oneToMany.targetEntity) && Objects.equals(mappedBy, oneToMany.mappedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(joinColumn, name, targetEntity, mappedBy);
    }
}
