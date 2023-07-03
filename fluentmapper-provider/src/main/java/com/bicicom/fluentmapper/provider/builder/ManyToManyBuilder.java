package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.expression.Expression;
import com.bicicom.fluentmapper.model.builder.JoinTableConfigurationBuilder;
import com.bicicom.fluentmapper.model.builder.ManyToManyConfigurationBuilder;
import com.bicicom.fluentmapper.provider.model.mutable.JoinTable;
import com.bicicom.fluentmapper.provider.model.mutable.ManyToManyRelationship;

import java.util.Collection;

public class ManyToManyBuilder<S, T> extends BaseModelBuilder implements ManyToManyConfigurationBuilder<S, T> {

    private final ManyToManyRelationship relationship;

    public ManyToManyBuilder(ManyToManyRelationship relationship) {
        this.relationship = relationship;
    }

    @Override
    public JoinTableConfigurationBuilder joinOnTable(String tableName) {
        var joinTable = new JoinTable();
        joinTable.setName(tableName);
        relationship.setJoinTable(joinTable);

        return new JoinTableBuilder(joinTable);
    }

    @Override
    public ManyToManyConfigurationBuilder<S, T> mappedBy(Expression<T, Collection<S>> propertyExpression) {
        this.relationship.setMappedBy(parse(propertyExpression).property());
        return this;
    }
}
