package com.bicicom.fluentmapper.provider.model.mutable;

import com.bicicom.fluentmapper.provider.model.ReadonlyColumn;


public class Column implements ReadonlyColumn {


    private String name = "";


    private int length = 255;


    private boolean nullable = true;


    private boolean unique = false;

    public Column() {
    }

    public Column(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    @Override
    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }
}
