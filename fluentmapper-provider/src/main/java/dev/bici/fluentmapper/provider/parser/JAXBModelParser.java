package dev.bici.fluentmapper.provider.parser;

import dev.bici.fluentmapper.provider.core.exception.FluentMapperException;
import dev.bici.fluentmapper.provider.model.Entity;
import dev.bici.fluentmapper.provider.model.EntityMappings;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.StringWriter;
import java.io.Writer;

/**
 * The current implementation, using JAXB to marshall the entities to XML. Pretty slow, but stable.
 */
class JAXBModelParser implements EntityModelParser {

    static final JAXBModelParser instance;

    static {
        instance = new JAXBModelParser();
    }

    private final JAXBContext jaxbContext;

    JAXBModelParser() {
        try {
            this.jaxbContext = JAXBContext.newInstance(EntityMappings.class);
        } catch (JAXBException e) {
            throw new FluentMapperException("Could not instantiate model parser;", e);
        }
    }

    @Override
    public String parseModels(Iterable<Entity> entityModels) {
        try {
            var entityMappings = new EntityMappings();
            entityMappings.setVersion("1.0");
            entityModels.forEach(entityMappings.getEntity()::add); // yikes

            var jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            Writer writer = new StringWriter();

            jaxbMarshaller.marshal(entityMappings, writer);

            return writer.toString();
        } catch (JAXBException e) {
            throw new FluentMapperException("Could not parse entity mappings;", e);
        }
    }

}
