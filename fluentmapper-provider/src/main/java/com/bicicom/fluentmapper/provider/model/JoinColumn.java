package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "join-column")
public class JoinColumn {

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "referenced-column-name")
    protected String referencedColumnName;
    @XmlAttribute(name = "unique")
    protected Boolean unique;
    @XmlAttribute(name = "nullable")
    protected Boolean nullable;

    @XmlAttribute(name = "table")
    protected String table;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setReferencedColumnName(String value) {
        this.referencedColumnName = value;
    }

    public void setUnique(Boolean value) {
        this.unique = value;
    }

    public void setNullable(Boolean value) {
        this.nullable = value;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String value) {
        this.table = value;
    }

}
