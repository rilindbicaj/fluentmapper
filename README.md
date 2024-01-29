## fluentmapper

Configure `JPA` entities programmatically. Inspired by `.NET's` `Entity Framework` fluent API for model configuration.

### Overview

`fluentmapper` is a library which allows you to configure `Jakarta Persistence API` models
not neither `XML` nor `annotations` - with a third, more sinister option - `lambda expressions`.

Utilizing runtime lambda expression bytecode analysis, `fluentmapper` accepts code-based model configuration
classes in the form of classes implementing the `EntityMapper` interface, and transforms them into `JPA` compliant
`XML` mappings, which can then be processed by the implementaiton of your liking.

Meaning, `fluentmapper` does not truly offer a third configuration option, merely a code-based, programmatic workaround
for the configuration options the `JPA` offers.

### ...what do you mean "with lambda expressions"?

`fluentmapper's` used a `domain-specific language` based on the usage of `lambda expressions`,
and/or `method references`,
to configure the `JPA` mappings of entities. They are used to specify, or "select", an entity's field (via `getter`, or
`field access` if you're feisty) to use in mapping configuration, providing a `type-safe`, Java code-based alternative
to
solutions offered by the `JPA`.

For example, you can configure a `User` model's `username` field to map to a column by the name of `user_name` by
providing
a `lambda expression` accessing this field to one of the mapping builders provided by the library.

```java
    modelBuilder.property(user->user.getUsername())
        .toColumn("user_name")
```

Or, a more Java-geared solution would be using a `method reference` to the field's `getter`.

```java
    modelBuilder.property(User::getUsername)
        .toColumn("user_name")
```

Referred to internally as simply `expressions`, these magical arrows make up the bulk of the builder API,
and provides `fluentmapper` with the knowledge required to construct and output these mappings according to
the entity they're intended for.

### Usage guide

#### Building locally

To build `fluentmapper` and have it available in your local repo, run `mvn clean install`.

#### Declaring dependencies

To use `fluentmapper` in your project, you must declare a dependency on its API.

```xml

<dependency>
    <groupId>dev.bici</groupId>
    <artifactId>fluentmapper-api</artifactId>
    <version>${fluentmapper.version}</version>
</dependency>
```

It's recommended to use the `fluentmapper-maven-plugin` in order to generate the mappings `XML` during the
project's build, making sure it's available for the `JPA` implementation beforehand.

```xml

<build>
    <plugins>
        <plugin>
            <groupId>dev.bici</groupId>
            <artifactId>fluentmapper-maven-plugin</artifactId>
            <version>${fluentmapper.version}</version>
            <executions>
                <execution>
                    <goals>
                        <goal>generate-mappings</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

The `fluentmapper-api` artifact provides the interfaces to be used for configuring your entities, whereas
the `fluentmapper-maven-plugin` will process these mapping classes into `XML`.

#### Creating your first mapping class

Now it's time to configure the mappings of your entity. In order to do so, you must create a new class to implement
the `EntityMapper` interface, providing you with an instance of `ModelBuilder` to get your hands dirty. Or fingertips.
Ideally neither, keep your keyboard clean.

Continuing our `User` entity example, we can create a `UserMapping` class to configure its `JPA` mappings.

```java
public final class UserMapping implements EntityMapper<User> {

    @Override
    public void configure(ModelBuilder<User> modelBuilder) {
    }

}
```

Now, having access to an instance of `ModelBuilder`, we can start the configuration process. Let's specify what table
our entity should map to, as well as the `schema` of the table.

```java
public final class UserMapping implements EntityMapper<User> {

    @Override
    public void configure(ModelBuilder<User> modelBuilder) {
        modelBuilder.toTable("users_table")
                .withSchema("some_schema");
    }

}
```

Beautiful. Now let's map something more interesting. Our entity has a `primary key`, a `JPA` `Id`. We can specify which
field corresponds to its primary key via the `hasKey` method.

```java
public final class UserMapping implements EntityMapper<User> {

    @Override
    public void configure(ModelBuilder<User> modelBuilder) {
        modelBuilder.toTable("users_table")
                .withSchema("some_schema");

        modelBuilder.hasKey(User::getId)
                .toColumn("user_id");
    }

}
```

This may look confusing at first, but it's rather simple concept - _the `User` entity's `id` field
is its `primary key`, which corresponds to the `user_id` column in its table representation._ We provide `fluentmapper`
with the `id` field via the `User::getId` method reference, which can alternatively also be expressed via lambda
expression -

```java
public final class UserMapping implements EntityMapper<User> {

    @Override
    public void configure(ModelBuilder<User> modelBuilder) {
        modelBuilder.toTable("users_table")
                .withSchema("some_schema");

        modelBuilder.hasKey(user -> user.getId())
                .toColumn("user_id");
    }

}
```

This expression can further be simplified if the `id` field is accessed directly. This of course, requires proper access
be given to the field (usually `public`) which for encapsulation purposes is not usually recommended.

```java
public final class UserMapping implements EntityMapper<User> {

    @Override
    public void configure(ModelBuilder<User> modelBuilder) {
        modelBuilder.toTable("users_table")
                .withSchema("some_schema");

        // Looks great! But wouldn't recommend.
        modelBuilder.hasKey(user -> user.id)
                .toColumn("user_id");
    }

}
```

Different builder API calls return different results - most of them return the same builder, so the mapping you're
currently configuring can be further worked on, whereas others return different builders to answer the order in which
they were called. In the above example, the `ModelBuilder` returns a `KeyBuilder` on call of `hasKey`, who then returns
a
`ColumnBuilder` on call of `toColumn`. Because a column has no nested mappings of its own, the `ColumnBuilder` won't
return
anything but itself, effectively limiting this method chain to itself. To configure something else, another chain has
to be started.

#### Entity relationships

Let's configure something a bit more complicated. Unlike you, entities belong in relationships, and often find
themselves entangled with one another. Our `User` entity has a `many-to-many` relationship with an `Address` entity,
which
can be expressed via this method chain -

```java
public final class UserMapping implements EntityMapper<User> {

    @Override
    public void configure(ModelBuilder<User> modelBuilder) {
        ...
        ...
        modelBuilder.hasMany(User::getAddresses)
                .withMany(Address::getUsers);
    }

}
```

Here we specify the `many-to-many` relationship between the `User` and `Address` entities. We use expressions to specify
the fields in `User` and `Address` which realize this relationship code-side - the `addresses` and `users` fields
respectively. For such a relationship to be realized, a `junction table` is necessary. This can also be configured by
extending the call chain -

```java
public final class UserMapping implements EntityMapper<User> {

    @Override
    public void configure(ModelBuilder<User> modelBuilder) {
        ...
        ...
        modelBuilder.hasMany(User::getAddresses)
                .withMany(Address::getUsers)
                .joinOnTable("users_addresses")
                .withForeignKey("users_addresses_user_id", "user_id")
                .withInverseForeignKey("users_addresses_address_id", 'address_id');
    }

}
```

Here we provide the details regarding the table this relationship is realized on. A table called `users_addresses` is
used
to relate these two entities, whose foreign keys (and primary keys) refer to the `user_id` and `address_id` primary keys
in the respective entities.

Notice how this relationship is `bi-directional`, as fields corresponding to the other related entity are present in
both
entities. By providing this mapping information, the `User` entity however, is declaring itself as the `owner` of this
relationship. Kinky! :flushed:

`fluentmapper` also addresses the issues of relationship `ownership` and `direction` by providing APIs which explicitly,
and
sometimes implicitly, mark the `owner` of the relationship. In the `User / Address` example, the `User` takes on the
`owner` role, leaving `Address` to simply specify its relationship as `mapped by my related entity`. This can be
achieved in the mapping class of the entity.

```java
public final class AddressMapping implements EntityMapper<Address> {

    @Override
    public void configure(ModelBuilder<Address> modelBuilder) {
        ...
        ...
        modelBuilder.hasMany(Address::getUsers)
                .withMany(User::getAddresses)
                .isMapped();
    }

}
```

Calling `isMapped` is equivalent to saying `this relationship is mapped by the appropriate field in the User entity`,
which `fluentmapper` knows to be the `addresses` field from previous method calls.

Next up is directionality. The previous example showcased a `User / Address` `many-to-many` relationship
which was `bidirectional`. With a few modifications, this relationship can be configured to be `unidirectional` instead.
For example, expecting the `Address` entity to keep a record of every `User` who lives on it is rather insane. So let's
make
this relationship `unidirectional`.

Because `unidirectionality` means the `users` field will be omitted from the `Address` entity, the `User` mapping file
needs to be tweaked to accommodate this. Instead of specifying the field in `Address` which realizes this relationship,
we
provide... nothing.

```java
public final class UserMapping implements EntityMapper<User> {

    @Override
    public void configure(ModelBuilder<User> modelBuilder) {
        ...
        ...
        modelBuilder.hasMany(User::getAddresses)
                .withMany()
                .joinOnTable("users_addresses")
                ...
    }

}
```

The `User` entity remains the owner of the relationship, and the relationship is reduced to a `unidirectional` one.

...and congratulations! That's all you need to know `fluentmapper`'s DSL and mapping syntax. Please refer to
the `javadoc`
to access info on all the available mappings currently configurable via `fluentmapper`.

### Generating the XML

Code-based configuration is not a thing in `JPA`. Therefore, we need to translate these class files into something
archaic
I mean different and understandable by the `JPA` implementation consuming them. This is where the `plugin` comes in.

Before the plugin can be executed, your `mapping classes` should be put inside a `package` of your choice. This is
important, as you need to provide this information to the plugin in its configuration.

```xml

<plugin>
    <groupId>dev.bici</groupId>
    <artifactId>fluentmapper-maven-plugin</artifactId>
    <version>${fluentmapper.version}</version>
    <configuration>
        <mappingsPackage>org.example.demoapp.models.mappings</mappingsPackage>
    </configuration>
    <executions>
        <execution>
            <goals>
                <goal>generate-mappings</goal>
            </goals>
        </execution>
    </executions>
</plugin>

```

Now, all that's left to do is `compile` your project with `mvn compile` or execute the goal directly via
`mvn fluentmapper:generate-mappings` and an `orm.xml` file will be generated in your build output's `META-INF` folder.
