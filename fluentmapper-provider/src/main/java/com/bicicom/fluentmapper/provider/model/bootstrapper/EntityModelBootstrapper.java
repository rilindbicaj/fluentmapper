package com.bicicom.fluentmapper.provider.model.bootstrapper;

import com.bicicom.fluentmapper.provider.core.exception.FluentMapperException;
import com.bicicom.fluentmapper.provider.core.loader.ModelClassloader;
import com.bicicom.fluentmapper.provider.model.Basic;
import com.bicicom.fluentmapper.provider.model.Entity;
import com.bicicom.fluentmapper.provider.model.Id;
import com.bicicom.fluentmapper.provider.model.Table;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Constructs new instances of EntityModel with default values reflectively accessed
 * from the entity class. Bootstraps an instance so that it's not necessary to define redundant mappings
 * like basic attributes and IDs.
 */

public final class EntityModelBootstrapper {

    private static final ClassLoader modelClassLoader = ModelClassloader.instance().getClassloader();
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
            Class<?> entityClass = Class.forName(qualifiedClassName, false, modelClassLoader);
            return new EntityModelBootstrapper(entityClass);
        } catch (ClassNotFoundException e) {
            throw new FluentMapperException("Could not create bootstrapper for model class " + qualifiedClassName, e);
        }
    }

    private static String toCamelCase(String className) {
        return Character.toLowerCase(className.charAt(0)) + className.substring(1);
    }

    /**
     * Determines whether a field of a model class is a candidate for being a {@link Basic} attribute.
     *
     * @param field the model field to check
     * @return true if the field is a basic attribute candidate, false otherwise
     */
    private boolean isBasicCandidate(Field field) {
        var fieldType = field.getType();
        return fieldType == Integer.class || fieldType == String.class; // Support more in the future
    }

    /**
     * Determines whether a field of the model class is a candidate for being a primary key. Currently
     * only supports camelCase naming, so a filed "user_id" would not pass the check.
     *
     * @param field the model field to check
     * @return true if the field can be considered a primary key by default, false otherwise
     */
    private boolean isKeyCandidate(Field field) {
        String entityClassName = this.entityClass.getSimpleName();
        return field.getName().equals("id") || field.getName().equals(toCamelCase(entityClassName) + "Id");
    }

    /**
     * Bootstraps an instance of {@link Entity} with set default attributes. This alleviates the need
     * to specify all necessary mappings manually, like primary keys or basic fields, in the mapping file.
     * <p>
     * The method sets the following {@link Entity} fields - {@link Basic}, {@link Id} and {@link Table}.
     * <p>
     * For example, a model <code>User</code> with the fields <code>id</code> and <code>name</code>, with a blank
     * mapping configuration class, will map <id>id</id> as the primary key, and <code>name</code> as a column in the
     * database table <code>users</code>. To be specific, it would output the following XML :
     *
     * <pre>
     *     {@code
     *      <table name="users" schema="public"></table>
     *      <attributes>
     *        <id name="id"></id>
     *        <basic name="name"></basic>
     *      </attributes>
     *     }
     * </pre>
     *
     * @return the bootstrapped {@link Entity} instance
     */
    public Entity bootstrap() {
        Entity entityModel = new Entity();
        String entityClassName = this.entityClass.getSimpleName();

        entityModel.setName(entityClassName);
        entityModel.setClazz(this.qualifiedClassName);

        List<Field> modelFields = List.of(this.entityClass.getDeclaredFields());
        List<Id> ids = this.findIdCandidates(modelFields);
        List<Basic> basics = this.findBasicCandidates(modelFields);

        Table table = new Table();
        table.setName(entityClassName.toLowerCase() + "s");

        entityModel.getAttributes().getId().addAll(ids);
        entityModel.getAttributes().getBasic().addAll(basics);
        entityModel.setTable(table);

        return entityModel;
    }

    /**
     * Finds all fields that are {@link Basic} candidates inside a list.
     *
     * @param modelFields the {@link Field} list to check.
     * @return a new list, with instances of all {@link Basic} candidates
     */
    private List<Basic> findBasicCandidates(List<Field> modelFields) {
        return modelFields.stream()
                .filter(this::isBasicCandidate)
                .map(FieldUtils::toBasic)
                .toList();
    }

    /**
     * Finds all fields that are {@link Id} candidates inside a list.
     *
     * @param modelFields the {@link Field} list to check.
     * @return a new list, with instances of all {@link Id} candidates
     */
    private List<Id> findIdCandidates(List<Field> modelFields) {
        return modelFields.stream()
                .filter(this::isKeyCandidate)
                .map(FieldUtils::toId)
                .toList();
    }

    /**
     * Utility class for transforming {@link Field} instances into XML model attribute instances.
     */
    private static class FieldUtils {

        static Id toId(Field field) {
            var id = new Id();
            id.setName(field.getName());
            return id;
        }

        static Basic toBasic(Field field) {
            var basic = new Basic();
            basic.setName(field.getName());
            return basic;
        }

    }

}
