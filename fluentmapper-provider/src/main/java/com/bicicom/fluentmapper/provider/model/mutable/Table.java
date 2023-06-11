package com.bicicom.fluentmapper.provider.model.mutable;

import com.bicicom.fluentmapper.provider.model.ReadonlyTable;


public class Table implements ReadonlyTable {


    private String name = "";

    private String schema = "";

    private String catalog = "";

    public Table() {

    }

    public Table(String name) {
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
    public String getSchema() {
        return schema;
    }


    public void setSchema(String schema) {
        this.schema = schema;
    }

    @Override
    public String getCatalog() {
        return catalog;
    }


    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
}
