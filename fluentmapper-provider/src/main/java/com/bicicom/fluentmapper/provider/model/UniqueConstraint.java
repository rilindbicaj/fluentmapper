package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "unique-constraint", propOrder = {
        "columnName"
})
public class UniqueConstraint {

    @XmlElement(name = "column-name", required = true)
    protected List<String> columnName;
    @XmlAttribute(name = "name")
    protected String name;

    public List<String> getColumnName() {
        if (columnName == null) {
            columnName = new ArrayList<String>();
        }
        return this.columnName;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

}
