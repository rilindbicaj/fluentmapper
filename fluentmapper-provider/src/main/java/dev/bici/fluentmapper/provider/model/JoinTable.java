package dev.bici.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "join-table", propOrder = {
        "joinColumn",
        "inverseJoinColumn",
})
public class JoinTable {

    @XmlElement(name = "join-column")
    protected List<JoinColumn> joinColumn;
    @XmlElement(name = "inverse-join-column")
    protected List<JoinColumn> inverseJoinColumn;

    @XmlAttribute(name = "name")
    protected String name;

    public List<JoinColumn> getJoinColumn() {
        if (joinColumn == null) {
            joinColumn = new ArrayList<JoinColumn>();
        }
        return this.joinColumn;
    }

    public List<JoinColumn> getInverseJoinColumn() {
        if (inverseJoinColumn == null) {
            inverseJoinColumn = new ArrayList<JoinColumn>();
        }
        return this.inverseJoinColumn;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

}
