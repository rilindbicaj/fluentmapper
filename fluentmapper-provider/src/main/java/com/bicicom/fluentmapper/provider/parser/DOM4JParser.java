package com.bicicom.fluentmapper.provider.parser;

import com.bicicom.fluentmapper.provider.model.ReadonlyEntityModel;
import com.bicicom.fluentmapper.provider.model.mutable.*;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.*;

class DOM4JParser {

    private static final Logger logger = LoggerFactory.getLogger(DOM4JParser.class);

    private final Map<Class<?>, String> tags;

    public DOM4JParser() {
        this.tags = new HashMap<>();

        this.tags.put(EntityModel.class, "entity");
        this.tags.put(Key.class, "id");
        this.tags.put(BasicAttribute.class, "basic");
        this.tags.put(Table.class, "table");
        this.tags.put(Column.class, "column");
    }

    private static void tryAddAttribute(Element e, Field f, Object o) {
        try {
            // Find a better way to parse _class
            String fieldName = f.getName().charAt(0) == '_' ? f.getName().substring(1) : f.getName();
            e.addAttribute(fieldName, f.get(o).toString());
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Element parseEntity(ReadonlyEntityModel entityModel) {
        logger.debug("Parsing mappings for {}", entityModel.getEntityClass());
        return this.recursiveParse(entityModel);
    }

    private Element recursiveParse(Object o) {
        Class<?> modelClass = o.getClass();
        String xmlTag = this.tags.get(modelClass);
        Element element = DocumentHelper.createElement(xmlTag);

        List<Field> modelFields = Arrays.stream(modelClass.getDeclaredFields()).toList();
        modelFields.forEach(field -> field.setAccessible(true));

        List<Field> attributeFields = modelFields.stream()
                .filter(this::isAttributeType)
                .toList();

        List<Field> collectionFields = modelFields.stream()
                .filter(field -> field.getType().isAssignableFrom(Map.class))
                .toList();
        List<Field> elementFields = modelFields.stream()
                .filter(field -> this.tags.get(field.getType()) != null)
                .toList();

        attributeFields.forEach(field -> tryAddAttribute(element, field, o));
        elementFields.forEach(elementField -> {
            element.add(this.tryParseElement(elementField, o));
        });
        collectionFields.forEach(field -> {
            element.add(tryParseCollection(field, o));
        });

        return element;
    }

    private boolean isAttributeType(Field field) {
        return field.getType() == String.class || field.getType() == int.class || field.getType() == boolean.class;
    }

    private Element tryParseElement(Field field, Object o) {
        try {
            return this.recursiveParse(field.get(o));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private Element tryParseCollection(Field field, Object o) {
        try {
            Element root = DocumentHelper.createElement(field.getName());
            Collection<?> collection = ((Map<?, ?>) field.get(o)).values();
            var sortedBySequence = collection.stream()
                    .sorted(Comparator.comparingInt((Object a) -> a.getClass().getAnnotation(Sequence.class).value()))
                    .toList();
            sortedBySequence.forEach(el -> {
                root.add(this.recursiveParse(el));
            });
            return root;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}