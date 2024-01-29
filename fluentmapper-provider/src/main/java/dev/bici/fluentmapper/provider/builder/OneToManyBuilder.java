package dev.bici.fluentmapper.provider.builder;

import dev.bici.fluentmapper.expression.Expression;
import dev.bici.fluentmapper.model.builder.OneToManyConfigurationBuilder;
import dev.bici.fluentmapper.provider.model.OneToMany;

public class OneToManyBuilder<S, T> extends BaseModelBuilder implements OneToManyConfigurationBuilder<S, T> {

    private final OneToMany relationship;

    OneToManyBuilder(OneToMany oneToManyRelationship) {
        this.relationship = oneToManyRelationship;
    }

    @Override
    public OneToManyConfigurationBuilder<S, T> mappedBy(Expression<T, S> propertyExpression) {
        relationship.setMappedBy(expressionParser.parse(propertyExpression).property());
        return this;
    }
}
