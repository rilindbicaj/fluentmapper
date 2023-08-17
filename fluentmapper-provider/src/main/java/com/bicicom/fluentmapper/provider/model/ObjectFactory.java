package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory {


    public ObjectFactory() {
    }

    public EntityMappings createEntityMappings() {
        return new EntityMappings();
    }

    public PersistenceUnitMetadata createPersistenceUnitMetadata() {
        return new PersistenceUnitMetadata();
    }

    public SequenceGenerator createSequenceGenerator() {
        return new SequenceGenerator();
    }

    public TableGenerator createTableGenerator() {
        return new TableGenerator();
    }

    public NamedQuery createNamedQuery() {
        return new NamedQuery();
    }

    public NamedNativeQuery createNamedNativeQuery() {
        return new NamedNativeQuery();
    }

    public SqlResultSetMapping createSqlResultSetMapping() {
        return new SqlResultSetMapping();
    }

    public MappedSuperclass createMappedSuperclass() {
        return new MappedSuperclass();
    }

    public Entity createEntity() {
        return new Entity();
    }

    public Embeddable createEmbeddable() {
        return new Embeddable();
    }

    public EmptyType createEmptyType() {
        return new EmptyType();
    }

    public PersistenceUnitDefaults createPersistenceUnitDefaults() {
        return new PersistenceUnitDefaults();
    }

    public AssociationOverride createAssociationOverride() {
        return new AssociationOverride();
    }

    public AttributeOverride createAttributeOverride() {
        return new AttributeOverride();
    }

    public Attributes createAttributes() {
        return new Attributes();
    }

    public Basic createBasic() {
        return new Basic();
    }

    public CascadeType createCascadeType() {
        return new CascadeType();
    }

    public CollectionTable createCollectionTable() {
        return new CollectionTable();
    }

    public Column createColumn() {
        return new Column();
    }

    public ColumnResult createColumnResult() {
        return new ColumnResult();
    }

    public DiscriminatorColumn createDiscriminatorColumn() {
        return new DiscriminatorColumn();
    }

    public ElementCollection createElementCollection() {
        return new ElementCollection();
    }

    public EmbeddableAttributes createEmbeddableAttributes() {
        return new EmbeddableAttributes();
    }

    public Embedded createEmbedded() {
        return new Embedded();
    }

    public EmbeddedId createEmbeddedId() {
        return new EmbeddedId();
    }

    public EntityListener createEntityListener() {
        return new EntityListener();
    }

    public EntityListeners createEntityListeners() {
        return new EntityListeners();
    }

    public EntityResult createEntityResult() {
        return new EntityResult();
    }

    public FieldResult createFieldResult() {
        return new FieldResult();
    }

    public GeneratedValue createGeneratedValue() {
        return new GeneratedValue();
    }

    public Id createId() {
        return new Id();
    }

    public IdClass createIdClass() {
        return new IdClass();
    }

    public Inheritance createInheritance() {
        return new Inheritance();
    }

    public JoinColumn createJoinColumn() {
        return new JoinColumn();
    }

    public JoinTable createJoinTable() {
        return new JoinTable();
    }

    public Lob createLob() {
        return new Lob();
    }

    public ManyToMany createManyToMany() {
        return new ManyToMany();
    }

    public ManyToOne createManyToOne() {
        return new ManyToOne();
    }

    public MapKey createMapKey() {
        return new MapKey();
    }

    public MapKeyClass createMapKeyClass() {
        return new MapKeyClass();
    }

    public MapKeyColumn createMapKeyColumn() {
        return new MapKeyColumn();
    }

    public MapKeyJoinColumn createMapKeyJoinColumn() {
        return new MapKeyJoinColumn();
    }

    public OneToMany createOneToMany() {
        return new OneToMany();
    }

    public OneToOne createOneToOne() {
        return new OneToOne();
    }

    public OrderColumn createOrderColumn() {
        return new OrderColumn();
    }

    public PostLoad createPostLoad() {
        return new PostLoad();
    }

    public PostPersist createPostPersist() {
        return new PostPersist();
    }

    public PostRemove createPostRemove() {
        return new PostRemove();
    }

    public PostUpdate createPostUpdate() {
        return new PostUpdate();
    }

    public PrePersist createPrePersist() {
        return new PrePersist();
    }

    public PreRemove createPreRemove() {
        return new PreRemove();
    }

    public PreUpdate createPreUpdate() {
        return new PreUpdate();
    }

    public PrimaryKeyJoinColumn createPrimaryKeyJoinColumn() {
        return new PrimaryKeyJoinColumn();
    }

    public QueryHint createQueryHint() {
        return new QueryHint();
    }

    public SecondaryTable createSecondaryTable() {
        return new SecondaryTable();
    }

    public Table createTable() {
        return new Table();
    }

    public Transient createTransient() {
        return new Transient();
    }

    public UniqueConstraint createUniqueConstraint() {
        return new UniqueConstraint();
    }

    public Version createVersion() {
        return new Version();
    }

}
