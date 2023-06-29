package com.bicicom.fluentmapper.provider.model.mutable;

import com.bicicom.fluentmapper.provider.model.ReadonlyKey;

@Sequence(1)
public class Key implements ReadonlyKey {

    private String name;

    private Column column;

    public Key(String name) {
        this.name = name;
        this.column = new Column();
        this.column.setName(name);
        this.column.setUnique(true);
        this.column.setNullable(false);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

}
