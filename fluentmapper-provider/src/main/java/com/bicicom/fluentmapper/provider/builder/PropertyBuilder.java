package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.model.builder.ColumnConfigurationBuilder;
import com.bicicom.fluentmapper.model.builder.FetchType;
import com.bicicom.fluentmapper.model.builder.PropertyConfigurationBuilder;
import com.bicicom.fluentmapper.provider.model.mutable.BasicAttribute;
import com.bicicom.fluentmapper.provider.model.mutable.Column;

public class PropertyBuilder implements PropertyConfigurationBuilder {

    private final BasicAttribute basicAttribute;

    public PropertyBuilder(BasicAttribute basicAttribute) {
        this.basicAttribute = basicAttribute;
    }

    @Override
    public ColumnConfigurationBuilder toColumn(String column) {
        Column propertyColumn = new Column(column);
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

    @Override
    public PropertyConfigurationBuilder hasFetchType(FetchType fetchType) {
        throw new UnsupportedOperationException();
    }
}
