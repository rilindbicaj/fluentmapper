package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.model.builder.ColumnConfigurationBuilder;
import com.bicicom.fluentmapper.model.builder.PropertyConfigurationBuilder;
import com.bicicom.fluentmapper.provider.model.Basic;
import com.bicicom.fluentmapper.provider.model.Column;

public class PropertyBuilder implements PropertyConfigurationBuilder {

    private final Basic basicAttribute;

    public PropertyBuilder(Basic basicAttribute) {
        this.basicAttribute = basicAttribute;
    }

    @Override
    public ColumnConfigurationBuilder toColumn(String columnName) {
        Column propertyColumn = new Column();
        propertyColumn.setName(columnName);

        basicAttribute.setColumn(propertyColumn);

        return new ColumnBuilder(propertyColumn);
    }

    @Override
    public PropertyConfigurationBuilder isOptional() {
        this.basicAttribute.setOptional(true);
        return this;
    }

    @Override
    public PropertyConfigurationBuilder isOptional(boolean value) {
        this.basicAttribute.setOptional(value);
        return this;
    }

}
