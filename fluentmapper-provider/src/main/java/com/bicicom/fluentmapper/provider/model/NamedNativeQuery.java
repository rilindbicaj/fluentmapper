package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "named-native-query", propOrder = {
        "description",
        "query",
        "hint"
})
public class NamedNativeQuery {

    protected String description;
    @XmlElement(required = true)
    protected String query;
    protected List<QueryHint> hint;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "result-class")
    protected String resultClass;
    @XmlAttribute(name = "result-set-mapping")
    protected String resultSetMapping;

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

    public String getResultClass() {
        return resultClass;
    }

    public void setResultClass(String value) {
        this.resultClass = value;
    }

    public String getResultSetMapping() {
        return resultSetMapping;
    }

    public void setResultSetMapping(String value) {
        this.resultSetMapping = value;
    }

}
