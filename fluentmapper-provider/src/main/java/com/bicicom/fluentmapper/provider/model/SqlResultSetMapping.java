package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sql-result-set-mapping", propOrder = {
        "description",
        "entityResult",
        "columnResult"
})
public class SqlResultSetMapping {

    protected String description;
    @XmlElement(name = "entity-result")
    protected List<EntityResult> entityResult;
    @XmlElement(name = "column-result")
    protected List<ColumnResult> columnResult;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public List<EntityResult> getEntityResult() {
        if (entityResult == null) {
            entityResult = new ArrayList<EntityResult>();
        }
        return this.entityResult;
    }

    public List<ColumnResult> getColumnResult() {
        if (columnResult == null) {
            columnResult = new ArrayList<ColumnResult>();
        }
        return this.columnResult;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

}
