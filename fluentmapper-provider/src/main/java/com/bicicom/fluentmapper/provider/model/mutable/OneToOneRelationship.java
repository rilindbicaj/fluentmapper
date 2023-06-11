package com.bicicom.fluentmapper.provider.model.mutable;

import com.bicicom.fluentmapper.provider.model.ReadonlyJoinColumn;
import com.bicicom.fluentmapper.provider.model.ReadonlyOneToOneRelationship;

public class OneToOneRelationship implements ReadonlyOneToOneRelationship {

    private String name;
    private String targetEntity;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getTargetEntity() {
        return targetEntity;
    }

    public void setTargetEntity(String targetEntity) {
        this.targetEntity = targetEntity;
    }

    @Override
    public String getMappedBy() {
        return null;
    }

    @Override
    public ReadonlyJoinColumn getJoinColumn() {
        return null;
    }
    
}
