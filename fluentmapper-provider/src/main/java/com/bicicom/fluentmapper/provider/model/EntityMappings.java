package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "description",
        "persistenceUnitMetadata",
        "_package",
        "schema",
        "catalog",
        "access",
        "sequenceGenerator",
        "tableGenerator",
        "namedQuery",
        "namedNativeQuery",
        "sqlResultSetMapping",
        "mappedSuperclass",
        "entity",
        "embeddable"
})
@XmlRootElement(name = "entity-mappings")
public class EntityMappings {

    protected String description;
    @XmlElement(name = "persistence-unit-metadata")
    protected PersistenceUnitMetadata persistenceUnitMetadata;
    @XmlElement(name = "package")
    protected String _package;
    protected String schema;
    protected String catalog;
    @XmlSchemaType(name = "token")
    protected AccessType access;
    @XmlElement(name = "sequence-generator")
    protected List<SequenceGenerator> sequenceGenerator;
    @XmlElement(name = "table-generator")
    protected List<TableGenerator> tableGenerator;
    @XmlElement(name = "named-query")
    protected List<NamedQuery> namedQuery;
    @XmlElement(name = "named-native-query")
    protected List<NamedNativeQuery> namedNativeQuery;
    @XmlElement(name = "sql-result-set-mapping")
    protected List<SqlResultSetMapping> sqlResultSetMapping;
    @XmlElement(name = "mapped-superclass")
    protected List<MappedSuperclass> mappedSuperclass;
    protected List<Entity> entity;
    protected List<Embeddable> embeddable;
    @XmlAttribute(name = "version", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String version;

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public PersistenceUnitMetadata getPersistenceUnitMetadata() {
        return persistenceUnitMetadata;
    }

    public void setPersistenceUnitMetadata(PersistenceUnitMetadata value) {
        this.persistenceUnitMetadata = value;
    }

    public String getPackage() {
        return _package;
    }

    public void setPackage(String value) {
        this._package = value;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String value) {
        this.schema = value;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String value) {
        this.catalog = value;
    }

    public AccessType getAccess() {
        return access;
    }

    public void setAccess(AccessType value) {
        this.access = value;
    }

    public List<SequenceGenerator> getSequenceGenerator() {
        if (sequenceGenerator == null) {
            sequenceGenerator = new ArrayList<SequenceGenerator>();
        }
        return this.sequenceGenerator;
    }

    public List<TableGenerator> getTableGenerator() {
        if (tableGenerator == null) {
            tableGenerator = new ArrayList<TableGenerator>();
        }
        return this.tableGenerator;
    }

    public List<NamedQuery> getNamedQuery() {
        if (namedQuery == null) {
            namedQuery = new ArrayList<NamedQuery>();
        }
        return this.namedQuery;
    }

    public List<NamedNativeQuery> getNamedNativeQuery() {
        if (namedNativeQuery == null) {
            namedNativeQuery = new ArrayList<NamedNativeQuery>();
        }
        return this.namedNativeQuery;
    }

    public List<SqlResultSetMapping> getSqlResultSetMapping() {
        if (sqlResultSetMapping == null) {
            sqlResultSetMapping = new ArrayList<SqlResultSetMapping>();
        }
        return this.sqlResultSetMapping;
    }

    public List<MappedSuperclass> getMappedSuperclass() {
        if (mappedSuperclass == null) {
            mappedSuperclass = new ArrayList<MappedSuperclass>();
        }
        return this.mappedSuperclass;
    }

    public List<Entity> getEntity() {
        if (entity == null) {
            entity = new ArrayList<Entity>();
        }
        return this.entity;
    }

    public List<Embeddable> getEmbeddable() {
        if (embeddable == null) {
            embeddable = new ArrayList<Embeddable>();
        }
        return this.embeddable;
    }

    public String getVersion() {
        if (version == null) {
            return "2.0";
        } else {
            return version;
        }
    }

    public void setVersion(String value) {
        this.version = value;
    }

}
