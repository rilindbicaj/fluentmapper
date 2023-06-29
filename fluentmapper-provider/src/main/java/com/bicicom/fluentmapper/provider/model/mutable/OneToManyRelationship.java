package com.bicicom.fluentmapper.provider.model.mutable;

import com.bicicom.fluentmapper.model.builder.FetchType;
import com.bicicom.fluentmapper.provider.model.ReadonlyOneToManyRelationship;

public final class OneToManyRelationship extends Relationship implements ReadonlyOneToManyRelationship {
    private String mappedBy;
    private JoinColumn joinColumn;
    private FetchType fetch_type;

    @Override
    public String getMappedBy() {
        return mappedBy;
    }

    public void setMappedBy(String mappedBy) {
        this.mappedBy = mappedBy;
    }

    @Override
    public JoinColumn getJoinColumn() {
        return joinColumn;
    }

    public void setJoinColumn(JoinColumn joinColumn) {
        this.joinColumn = joinColumn;
    }
}
