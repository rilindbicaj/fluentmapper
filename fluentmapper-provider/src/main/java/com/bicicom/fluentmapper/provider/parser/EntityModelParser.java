package com.bicicom.fluentmapper.provider.parser;

import com.bicicom.fluentmapper.provider.model.ReadonlyEntityModel;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.StringWriter;

public class EntityModelParser {

    private final Document document;
    private final DOM4JParser parser;


    public EntityModelParser() {
        this.document = DocumentHelper.createDocument(
                DocumentHelper.createElement("entity-mappings")
        );
        this.parser = new DOM4JParser();
    }

    private String prettier() {
        final StringWriter sw;

        try {
            final OutputFormat format = OutputFormat.createPrettyPrint();
            sw = new StringWriter();
            final XMLWriter writer = new XMLWriter(sw, format);
            writer.write(this.document);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sw.toString();
    }

    public EntityMappings parseModels(Iterable<ReadonlyEntityModel> entityModels) {
        entityModels.forEach(model -> {
            this.document.getRootElement().add(parser.parseEntity(model));
        });

        return new EntityMappings(prettier());
    }


}
