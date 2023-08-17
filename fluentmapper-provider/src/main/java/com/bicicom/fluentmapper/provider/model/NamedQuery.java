package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "named-query", propOrder = {
        "description",
        "query",
        "lockMode",
        "hint"
})
public class NamedQuery {

    protected String description;
    @XmlElement(required = true)
    protected String query;
    @XmlElement(name = "lock-mode")
    @XmlSchemaType(name = "token")
    protected LockModeType lockMode;
    protected List<QueryHint> hint;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String value) {
        this.query = value;
    }

    public LockModeType getLockMode() {
        return lockMode;
    }

    public void setLockMode(LockModeType value) {
        this.lockMode = value;
    }

    public List<QueryHint> getHint() {
        if (hint == null) {
            hint = new ArrayList<QueryHint>();
        }
        return this.hint;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

}
