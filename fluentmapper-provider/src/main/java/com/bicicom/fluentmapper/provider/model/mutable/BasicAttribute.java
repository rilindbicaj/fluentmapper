package com.bicicom.fluentmapper.provider.model.mutable;

import com.bicicom.fluentmapper.provider.model.ReadonlyBasicAttribute;

@Sequence(2)
public class BasicAttribute implements ReadonlyBasicAttribute {

    private String name;

    private boolean optional = true;

    private Column column;

    public BasicAttribute(String name) {
        this.name = name;
        this.column = new Column(name);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    @Override
    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

}
