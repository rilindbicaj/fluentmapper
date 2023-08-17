package com.bicicom.fluentmapper.provider.model;

import com.bicicom.fluentmapper.provider.model.set.ModelSet;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attributes", propOrder = {
        "description",
        "id",
        "embeddedId",
        "basic",
        "version",
        "manyToOne",
        "oneToMany",
        "oneToOne",
        "manyToMany",
        "elementCollection",
        "embedded",
        "_transient"
})
public class Attributes {

    protected String description;
    protected Set<Id> id;
    @XmlElement(name = "embedded-id")
    protected EmbeddedId embeddedId;
    protected Set<Basic> basic;
    protected Set<Version> version;
    @XmlElement(name = "many-to-one")
    protected Set<ManyToOne> manyToOne;
    @XmlElement(name = "one-to-many")
    protected Set<OneToMany> oneToMany;
    @XmlElement(name = "one-to-one")
    protected Set<OneToOne> oneToOne;
    @XmlElement(name = "many-to-many")
    protected Set<ManyToMany> manyToMany;
    @XmlElement(name = "element-collection")
    protected List<ElementCollection> elementCollection;
    protected List<Embedded> embedded;
    @XmlElement(name = "transient")
    protected List<Transient> _transient;

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public Set<Id> getId() {
        if (id == null) {
            id = new ModelSet<>();
        }
        return this.id;
    }

    public EmbeddedId getEmbeddedId() {
        return embeddedId;
    }

    public void setEmbeddedId(EmbeddedId value) {
        this.embeddedId = value;
    }

    public Set<Basic> getBasic() {
        if (basic == null) {
            basic = new ModelSet<>();
        }
        return this.basic;
    }

    public Set<Version> getVersion() {
        if (version == null) {
            version = new ModelSet<>();
        }
        return this.version;
    }

    public Set<ManyToOne> getManyToOne() {
        if (manyToOne == null) {
            manyToOne = new ModelSet<>();
        }
        return this.manyToOne;
    }

    public Set<OneToMany> getOneToMany() {
        if (oneToMany == null) {
            oneToMany = new ModelSet<>();
        }
        return this.oneToMany;
    }

    public Set<OneToOne> getOneToOne() {
        if (oneToOne == null) {
            oneToOne = new ModelSet<>();
        }
        return this.oneToOne;
    }

    public Set<ManyToMany> getManyToMany() {
        if (manyToMany == null) {
            manyToMany = new ModelSet<>();
        }
        return this.manyToMany;
    }

    public List<ElementCollection> getElementCollection() {
        if (elementCollection == null) {
            elementCollection = new ArrayList<ElementCollection>();
        }
        return this.elementCollection;
    }

    public List<Embedded> getEmbedded() {
        if (embedded == null) {
            embedded = new ArrayList<Embedded>();
        }
        return this.embedded;
    }

    public List<Transient> getTransient() {
        if (_transient == null) {
            _transient = new ArrayList<Transient>();
        }
        return this._transient;
    }

}
