package com.bicicom.fluentmapper.provider.model.mutable;

import com.bicicom.fluentmapper.provider.model.ReadonlyJoinTable;

public class JoinTable implements ReadonlyJoinTable {
    private String name;
    private JoinColumn join_column;
    private InverseJoinColumn inverse_join_column;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public JoinColumn getJoinColumn() {
        return join_column;
    }

    public void setJoinColumn(JoinColumn joinColumn) {
        this.join_column = joinColumn;
    }

    @Override
    public JoinColumn getInverseJoinColumn() {
        return inverse_join_column;
    }

    public void setInverseJoinColumn(InverseJoinColumn inverseJoinColumn) {
        this.inverse_join_column = inverseJoinColumn;
    }
}
