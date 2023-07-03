package com.bicicom.fluentmapper.provider.model.mutable;

@Sequence(4)
public final class ManyToManyRelationship extends Relationship {

    private JoinTable join_table;
    private String mapped_by;

    public JoinTable getJoinTable() {
        return join_table;
    }

    public void setJoinTable(JoinTable joinTable) {
        this.join_table = joinTable;
    }

    public String getMappedBy() {
        return mapped_by;
    }

    public void setMappedBy(String mappedBy) {
        this.mapped_by = mappedBy;
    }

}
