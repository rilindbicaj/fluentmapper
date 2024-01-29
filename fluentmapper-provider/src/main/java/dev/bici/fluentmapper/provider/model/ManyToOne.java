package dev.bici.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "many-to-one", propOrder = {
        "joinColumn",
})
public class ManyToOne {

    @XmlElement(name = "join-column")
    protected List<JoinColumn> joinColumn;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "target-entity")
    protected String targetEntity;
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

    public void setId(Boolean value) {
        this.id = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManyToOne manyToOne = (ManyToOne) o;
        return Objects.equals(joinColumn, manyToOne.joinColumn) && Objects.equals(name, manyToOne.name) && Objects.equals(targetEntity, manyToOne.targetEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(joinColumn, name, targetEntity);
    }
}
