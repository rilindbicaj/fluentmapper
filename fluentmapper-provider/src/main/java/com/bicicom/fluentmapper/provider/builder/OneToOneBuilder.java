package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.expression.Expression;
import com.bicicom.fluentmapper.model.builder.JoinColumnConfigurationBuilder;
import com.bicicom.fluentmapper.model.builder.OneToOneConfigurationBuilder;
import com.bicicom.fluentmapper.provider.model.mutable.JoinColumn;
import com.bicicom.fluentmapper.provider.model.mutable.OneToOneRelationship;

public class OneToOneBuilder<S, T> extends BaseModelBuilder implements OneToOneConfigurationBuilder<S, T> {

    private final String withOne;
    private final OneToOneRelationship relationship;

    OneToOneBuilder(OneToOneRelationship relationship, String withOne) {
        this.relationship = relationship;
        this.withOne = withOne;
    }

    @Override
    public OneToOneConfigurationBuilder<S, T> mappedBy(Expression<T, S> propertyExpression) {
        var mappedProperty = parse(propertyExpression).property();
        relationship.setMappedBy(mappedProperty);

        return this;
    }

    @Override
    public OneToOneConfigurationBuilder<S, T> isMapped() {
        this.relationship.setMappedBy(withOne);
        return this;
    }

    @Override
    public JoinColumnConfigurationBuilder hasForeignKey(String foreignKeyProperty) {
        var joinColumn = new JoinColumn();
        joinColumn.setName(foreignKeyProperty);

        relationship.setJoinColumn(joinColumn);

        return new JoinColumnBuilder(joinColumn);
    }

}
