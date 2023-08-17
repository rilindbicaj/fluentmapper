package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;

import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "id", propOrder = {
        "column",
        "generatedValue",
        "temporal",
        "tableGenerator",
        "sequenceGenerator"
})
public class Id {

    protected Column column;
    @XmlElement(name = "generated-value")
    protected GeneratedValue generatedValue;
    @XmlSchemaType(name = "token")
    protected TemporalType temporal;
    @XmlElement(name = "table-generator")
    protected TableGenerator tableGenerator;
    @XmlElement(name = "sequence-generator")
    protected SequenceGenerator sequenceGenerator;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "access")
    protected AccessType access;

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column value) {
        this.column = value;
    }

    public GeneratedValue getGeneratedValue() {
        return generatedValue;
    }

    public void setGeneratedValue(GeneratedValue value) {
        this.generatedValue = value;
    }

    public TemporalType getTemporal() {
        return temporal;
    }

    public void setTemporal(TemporalType value) {
        this.temporal = value;
    }

    public TableGenerator getTableGenerator() {
        return tableGenerator;
    }

    public void setTableGenerator(TableGenerator value) {
        this.tableGenerator = value;
    }

    public SequenceGenerator getSequenceGenerator() {
        return sequenceGenerator;
    }

    public void setSequenceGenerator(SequenceGenerator value) {
        this.sequenceGenerator = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public AccessType getAccess() {
        return access;
    }

    public void setAccess(AccessType value) {
        this.access = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id id = (Id) o;
        return Objects.equals(name, id.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
