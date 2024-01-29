package dev.bici.fluentmapper.provider.model;

import dev.bici.fluentmapper.provider.model.set.ReplacerSet;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.Set;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attributes", propOrder = {
        "id",
        "basic",
        "manyToOne",
        "oneToMany",
        "oneToOne",
        "manyToMany",
})
public class Attributes {

    protected Set<Id> id;
    protected Set<Basic> basic;
    @XmlElement(name = "many-to-one")
    protected Set<ManyToOne> manyToOne;
    @XmlElement(name = "one-to-many")
    protected Set<OneToMany> oneToMany;
    @XmlElement(name = "one-to-one")
    protected Set<OneToOne> oneToOne;
    @XmlElement(name = "many-to-many")
    protected Set<ManyToMany> manyToMany;

    public Set<Id> getId() {
        if (id == null) {
            id = new ReplacerSet<>();
        }
        return this.id;
    }

    public Set<Basic> getBasic() {
        if (basic == null) {
            basic = new ReplacerSet<>();
        }
        return this.basic;
    }

    public Set<ManyToOne> getManyToOne() {
        if (manyToOne == null) {
            manyToOne = new ReplacerSet<>();
        }
        return this.manyToOne;
    }

    public Set<OneToMany> getOneToMany() {
        if (oneToMany == null) {
            oneToMany = new ReplacerSet<>();
        }
        return this.oneToMany;
    }

    public Set<OneToOne> getOneToOne() {
        if (oneToOne == null) {
            oneToOne = new ReplacerSet<>();
        }
        return this.oneToOne;
    }

    public Set<ManyToMany> getManyToMany() {
        if (manyToMany == null) {
            manyToMany = new ReplacerSet<>();
        }
        return this.manyToMany;
    }

}
