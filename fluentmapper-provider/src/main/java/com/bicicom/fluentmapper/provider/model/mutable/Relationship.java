package com.bicicom.fluentmapper.provider.model.mutable;

import com.bicicom.fluentmapper.provider.model.ReadonlyRelationship;

public sealed class Relationship implements ReadonlyRelationship permits ManyToManyRelationship, ManyToOneRelationship, OneToManyRelationship, OneToOneRelationship {
    private String name;
    private String target_entity;

    // TODO - Remove this, many-to-one does not have it (needs major refactoring)
    private String mapped_by;
    private JoinColumn joinColumn;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getTargetEntity() {
        return target_entity;
    }

    public void setTargetEntity(String targetEntity) {
        this.target_entity = targetEntity;
    }

    @Override
    public String getMappedBy() {
        return this.mapped_by;
    }

    public void setMappedBy(String mappedBy) {
        this.mapped_by = mappedBy;
    }

    @Override
    public JoinColumn getJoinColumn() {
        return joinColumn;
    }

    public void setJoinColumn(JoinColumn joinColumn) {
        this.joinColumn = joinColumn;
    }
}
