/**
 * Contains class representations of supported JPA mappings, to be used by the model builders in order to store the final
 * domain model configuration. Their serialization to XML is currently supported by Jakarta XML Binding.
 */
@XmlSchema(namespace = "http://java.sun.com/xml/ns/persistence/orm", elementFormDefault = XmlNsForm.QUALIFIED)
package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;