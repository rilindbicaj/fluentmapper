package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "persistence-unit-metadata", propOrder = {
        "description",
        "xmlMappingMetadataComplete",
        "persistenceUnitDefaults"
})
public class PersistenceUnitMetadata {

    protected String description;
    @XmlElement(name = "xml-mapping-metadata-complete")
    protected EmptyType xmlMappingMetadataComplete;
    @XmlElement(name = "persistence-unit-defaults")
    protected PersistenceUnitDefaults persistenceUnitDefaults;

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public EmptyType getXmlMappingMetadataComplete() {
        return xmlMappingMetadataComplete;
    }

    public void setXmlMappingMetadataComplete(EmptyType value) {
        this.xmlMappingMetadataComplete = value;
    }

    public PersistenceUnitDefaults getPersistenceUnitDefaults() {
        return persistenceUnitDefaults;
    }

    public void setPersistenceUnitDefaults(PersistenceUnitDefaults value) {
        this.persistenceUnitDefaults = value;
    }

}
