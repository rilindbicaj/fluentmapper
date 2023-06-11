package com.bicicom.fluentmapper.provider.model.mutable;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Constructs new instances of EntityModel with default values reflectively accessed
 * from the entity class. Bootstraps an instance so that it's not necessary to define redundant mappings
 * like basic attributes and IDs.
 */

public final class EntityModelBootstrapper {

    private final Class<?> entityClass;
    private final String qualifiedClassName;

    private EntityModelBootstrapper(Class<?> entityClass) {
        this.entityClass = entityClass;
        this.qualifiedClassName = entityClass.getName();
    }

    /**
     * Creates and sets up a boostrappper for an entity class.
     *
     * @param qualifiedClassName the qualified class name of the entity
     * @return an instance of the bootstrapper able to create bootstrapped EntityModel objects for the provided entity
     */

    public static EntityModelBootstrapper forClass(String qualifiedClassName) {
        try {
            Class<?> entityClass = Class.forName(qualifiedClassName);
            return new EntityModelBootstrapper(entityClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Could maybe support other cases besides CamelCase...maybe...possibly
    private static boolean isKeyCandidate(String fieldName, String entityClassName) {
        return fieldName.equals("id") || fieldName.equals(toCamelCase(entityClassName) + "Id");
    }

    private static String toCamelCase(String className) {
        return Character.toLowerCase(className.charAt(0)) + className.substring(1);
    }

    public EntityModel bootstrap() {
        EntityModel entityModel = new EntityModel(this.entityClass.getSimpleName(), this.qualifiedClassName);
        String entityClassName = this.entityClass.getSimpleName();

        List<Field> modelFields = List.of(this.entityClass.getDeclaredFields());
        List<Key> ids = this.findIdCandidates(modelFields, entityClassName);
        List<BasicAttribute> basics = this.findBasicCandidates(modelFields, entityClassName);

        ids.forEach(entityModel::addKey);
        basics.forEach(entityModel::addBasicAttribute);

        entityModel.setTable(new Table(entityClassName));

        return entityModel;
    }

    private List<BasicAttribute> findBasicCandidates(List<Field> modelFields, String entityClassName) {
        return modelFields.stream()
                .filter(field -> !isKeyCandidate(field.getName(), this.entityClass.getSimpleName()))
                .map(field -> new BasicAttribute(field.getName()))
                .toList();
    }

    private List<Key> findIdCandidates(List<Field> modelFields, String entityClassName) {
        return modelFields.stream()
                .filter(field -> isKeyCandidate(field.getName(), this.entityClass.getSimpleName()))
                .map(field -> new Key(field.getName()))
                .toList();
    }

}
