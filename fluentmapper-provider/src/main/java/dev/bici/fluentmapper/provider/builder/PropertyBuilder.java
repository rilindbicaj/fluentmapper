package dev.bici.fluentmapper.provider.builder;

import dev.bici.fluentmapper.model.builder.ColumnConfigurationBuilder;
import dev.bici.fluentmapper.model.builder.PropertyConfigurationBuilder;
import dev.bici.fluentmapper.provider.model.Basic;
import dev.bici.fluentmapper.provider.model.Column;

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
