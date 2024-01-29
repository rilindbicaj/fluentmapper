package dev.bici.fluentmapper.expression;

import java.io.Serializable;
import java.util.function.Function;

/**
 * A lambda expression or method reference to be used for accessing a class field
 * via direct field access or getter respectively, and by doing so, contain within
 * itself the metadata necessary to extract the field accessed by it. Expressions
 * can later be parsed to extract this metadata at runtime, giving access to the
 * field accessed, its return type (referred to as the {@code target}, and the
 * class which contains it (referred to as the {@code source}).
 * <p>
 * In the context of FluentMapper, expressions are to be used for providing the
 * model builders with the fields from the domain model class they configure, in
 * order to reference them in their constructed mappings.
 * <p>
 * <b>
 * Expressions are not intended to hold anything but field accesses.
 * </b> Using them
 * for anything else might cause unexpected results, or crashes.
 * <p>
 * In the example below, a {@code User} domain model's {@code username} field
 * is being accessed in a variety of accepted methods - via direct field access, via
 * lambda getter, and via method reference getter.
 * <pre>
 * {@code
 * Expression<User,String> username = (user) -> user.username;
 * Expression<User,String> username = (user) -> user.getUsername();
 * Expression<User,String> username = User::getUsername;
 * }
 * </pre>
 *
 * @param <S> the {@code source} entity, whose fields are to be accessed
 * @param <T> the {@code target}, specifically the type of the field being accessed.
 */
@FunctionalInterface
public interface Expression<S, T> extends Function<S, T>, Serializable {
}
