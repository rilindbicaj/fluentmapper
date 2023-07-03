package com.bicicom.fluentmapper.provider.parser;

import com.bicicom.fluentmapper.provider.model.mutable.EntityModel;
import com.bicicom.fluentmapper.provider.model.mutable.ManyToManyRelationship;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.jupiter.api.*;

public class RecursiveParserTests {

    private static DOM4JParser parser;
    private EntityModel entityModel;

    @BeforeAll
    public static void init() {
        parser = new DOM4JParser();
    }

    @BeforeEach
    public void prepare() {
        this.entityModel = new EntityModel();
        this.entityModel.setName("test-model");
    }

    @Test
    public void assertTrue() {
        ManyToManyRelationship manyToManyRelationship = new ManyToManyRelationship();
        manyToManyRelationship.setMappedBy("mappedByProperty");
        manyToManyRelationship.setName("propertyName");

        entityModel.addRelationship(manyToManyRelationship);
        var res = parser.parseEntity(entityModel);
        res.asXML();
    }

    @Test
    public void diqka() {
        Element element = DocumentHelper.createElement("test");
        element.add(DocumentHelper.createElement("s"));

        System.out.println(element.asXML());
    }

    @Nested
    @DisplayName("Parsing of basic attributes")
    class BasicAttributeParseTests {

        @Test
        @DisplayName("Should correctly parse basic's attributes")
        public void test() {
//            BasicAttribute basicAttribute = new BasicAttribute("property");
//            basicAttribute.setOptional(true);
//            entityModel.addBasicAttribute(basicAttribute);
//
//            var parsedResult = parser.parseEntity(entityModel).asXML();
//            var expectedResult = """
//                    <entity-model>
//                        <attributes>
//                            <basic name="property" optional="true">
//
//                            </basic>
//                        </attributes>
//                    </test-model>
//
//                    """;
//            Assertions.assertEquals(expectedResult, parsedResult);
        }

    }

}


