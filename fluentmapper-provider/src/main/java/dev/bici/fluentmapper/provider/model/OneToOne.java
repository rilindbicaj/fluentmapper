package dev.bici.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "one-to-one", propOrder = {
        "joinColumn",
})
public class OneToOne {

    @XmlElement(name = "join-column")
    protected List<JoinColumn> joinColumn;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "target-entity")
    protected String targetEntity;
    @XmlAttribute(name = "mapped-by")
    protected String mappedBy;
    @XmlAttribute(name = "id")
    protected Boolean id;

    public List<JoinColumn> getJoinColumn() {
        if (joinColumn == null) {
            joinColumn = new ArrayList<JoinColumn>();
        }
        return this.joinColumn;
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

    public void setId(Boolean value) {
        this.id = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OneToOne oneToOne = (OneToOne) o;
        return Objects.equals(joinColumn, oneToOne.joinColumn) && Objects.equals(name, oneToOne.name) && Objects.equals(targetEntity, oneToOne.targetEntity) && Objects.equals(mappedBy, oneToOne.mappedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(joinColumn, name, targetEntity, mappedBy);
    }
}
