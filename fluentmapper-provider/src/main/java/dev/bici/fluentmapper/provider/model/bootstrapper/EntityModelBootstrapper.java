package dev.bici.fluentmapper.provider.model.bootstrapper;

import dev.bici.fluentmapper.provider.core.classloader.ModelClassLoader;
import dev.bici.fluentmapper.provider.core.exception.FluentMapperException;
import dev.bici.fluentmapper.provider.model.Basic;
import dev.bici.fluentmapper.provider.model.Entity;
import dev.bici.fluentmapper.provider.model.Id;
import dev.bici.fluentmapper.provider.model.Table;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * Constructs new instances of {@link Entity} given a client entity / domain class. Populates the instance with default values,
 * such as the <b>entity's name</b>, <b>table</b>, <b>primary key</b>, and <b>basic fields</b>.
 * </p>
 * <p>
 * These values are extracted from the class' metadata, attempting to guess which fields corresponds to their respective
 * JPA mappings. They can always be overridden via builder later on - the bootstrapper's role is removing the need
 * to specify the simple mappings.
 * </p>
 */
public final class EntityModelBootstrapper {

    /**
     * The {@link ModelClassLoader} used for loading the client entity class.
     */
    private static final ModelClassLoader modelClassLoader = ModelClassLoader.INSTANCE;

    /**
     * The set of types assumed to be candidates for being a {@link Basic} mapping.
     */
    private static final Set<Class<?>> BASIC_CANDIDATE_TYPES = Set.of(Integer.class, String.class);

    /**
     * The client entity class to be bootstrapped.
     */
    private final Class<?> entityClass;

    private EntityModelBootstrapper(Class<?> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Creates and sets up a bootstrapper for the entity class corresponding to the provided name.
     *
     * @param qualifiedClassName the qualified class name of the entity
     * @return an instance of the bootstrapper able to create bootstrapped EntityModel objects for the provided entity
     */
    public static EntityModelBootstrapper forClass(String qualifiedClassName) {
        try {
            Class<?> entityClass = modelClassLoader.getClassLoader().loadClass(qualifiedClassName);
            return new EntityModelBootstrapper(entityClass);
        } catch (ClassNotFoundException e) {
            throw new FluentMapperException("Could not create bootstrapper for model class " + qualifiedClassName, e);
        }
    }

    private static String toCamelCase(String className) {
        return Character.toLowerCase(className.charAt(0)) + className.substring(1);
    }

    /**
     * Determines whether a field of an entity class is a candidate for being a {@link Basic} attribute.
     *
     * @param field the entity class field to check
     * @return <b>true</b> if the field is a {@link Basic} candidate, <b>false</b> otherwise
     */
    private boolean isBasicCandidate(Field field) {
        return BASIC_CANDIDATE_TYPES.contains(field.getType());
    }

    /**
     * <p>
     * Determines whether a field of the model class is a candidate for being a primary key. Currently only supports
     * <code>camelCase</code> naming.
     * </p>
     * <p>
     * For example, the following class
     * <pre>
     *     {@code
     *       public class User {
     *          int id;
     *          String name;
     *       }
     *     }
     * </pre>
     * would have its <code>id</code> field considered as a primary key candidate. That would also be the case if the
     * field was named <code>userId</code> instead.
     * </p>
     *
     * @param field the entity class field to check
     * @return <b>true</b> if the field can be considered a primary key by default, <b>false</b> otherwise
     */
    private boolean isKeyCandidate(Field field) {
        String entityClassName = this.entityClass.getSimpleName();
        return field.getName().equals("id") || field.getName().equals(toCamelCase(entityClassName) + "Id");
    }

    /**
     * <p>
     * Bootstraps an instance of {@link Entity} with set default attributes. This alleviates the need
     * to specify all necessary mappings manually, like primary keys or basic fields, in the mapping file.
     * The method sets the following {@link Entity} fields - {@link Basic}, {@link Id} and {@link Table}.
     * </p>
     * <p>
     * For example, an entity class such as
     * </p>
     * <pre>
     * public class User {
     *      int id;
     *      String name;
     * }
     * </pre>
     * <p>would output the following XML if no further configurations are applied - </p>
     * <pre>
     * {@code
     * <table name="users" schema="public"></table>
     * <attributes>
     *      <id name="id"></id>
     *      <basic name="name"></basic>
     * </attributes>
     * }
     * </pre>
     *
     * @return the bootstrapped {@link Entity} instance
     */
    public Entity bootstrap() {
        Entity entityModel = new Entity();
        String entityClassName = this.entityClass.getSimpleName();

        entityModel.setName(entityClassName);
        entityModel.setClazz(this.entityClass.getName());

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
