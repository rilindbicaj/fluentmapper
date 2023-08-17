package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "persistence-unit-defaults", propOrder = {
        "description",
        "schema",
        "catalog",
        "delimitedIdentifiers",
        "access",
        "cascadePersist",
        "entityListeners"
})
public class PersistenceUnitDefaults {

    protected String description;
    protected String schema;
    protected String catalog;
    @XmlElement(name = "delimited-identifiers")
    protected EmptyType delimitedIdentifiers;
    @XmlSchemaType(name = "token")
    protected AccessType access;
    @XmlElement(name = "cascade-persist")
    protected EmptyType cascadePersist;
    @XmlElement(name = "entity-listeners")
    protected EntityListeners entityListeners;

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
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

    public EmptyType getDelimitedIdentifiers() {
        return delimitedIdentifiers;
    }

    public void setDelimitedIdentifiers(EmptyType value) {
        this.delimitedIdentifiers = value;
    }

    public AccessType getAccess() {
        return access;
    }

    public void setAccess(AccessType value) {
        this.access = value;
    }

    public EmptyType getCascadePersist() {
        return cascadePersist;
    }

    public void setCascadePersist(EmptyType value) {
        this.cascadePersist = value;
    }

    public EntityListeners getEntityListeners() {
        return entityListeners;
    }

    public void setEntityListeners(EntityListeners value) {
        this.entityListeners = value;
    }

}
