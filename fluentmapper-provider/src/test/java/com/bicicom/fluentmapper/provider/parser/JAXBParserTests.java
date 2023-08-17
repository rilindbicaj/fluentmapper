package com.bicicom.fluentmapper.provider.parser;

import com.bicicom.fluentmapper.provider.model.Entity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class JAXBParserTests {

    private static JAXBModelParser parser;
    private Entity entityModel;

    @BeforeAll
    public static void init() {
        parser = new JAXBModelParser();
    }

    @BeforeEach
    public void prepare() {
        this.entityModel = new Entity();
        this.entityModel.setName("test-model");
    }

//    @Test
//    public void assertTrue() {
//        ManyToMany manyToManyRelationship = new ManyToManyRelationship();
//        manyToManyRelationship.setMappedBy("mappedByProperty");
//        manyToManyRelationship.setName("propertyName");
//
//        entityModel.addRelationship(manyToManyRelationship);
//        var res = parser.parseEntity(entityModel);
//        res.asXML();
//    }
//
//    @Test
//    public void diqka() {
//        Element element = DocumentHelper.createElement("test");
//        element.add(DocumentHelper.createElement("s"));
//
//        System.out.println(element.asXML());
//    }

}


