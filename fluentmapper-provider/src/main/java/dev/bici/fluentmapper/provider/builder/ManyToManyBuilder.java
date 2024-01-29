package dev.bici.fluentmapper.provider.builder;

import dev.bici.fluentmapper.expression.Expression;
import dev.bici.fluentmapper.model.builder.JoinTableConfigurationBuilder;
import dev.bici.fluentmapper.model.builder.ManyToManyConfigurationBuilder;
import dev.bici.fluentmapper.provider.model.JoinTable;
import dev.bici.fluentmapper.provider.model.ManyToMany;

import java.util.Collection;

public class ManyToManyBuilder<S, T> extends BaseModelBuilder implements ManyToManyConfigurationBuilder<S, T> {

    private final ManyToMany relationship;
    private final String hostMappingProperty;

    public ManyToManyBuilder(ManyToMany relationship, String hostMappingProperty) {
        this.relationship = relationship;
        this.hostMappingProperty = hostMappingProperty;
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
        this.relationship.setMappedBy(expressionParser.parse(propertyExpression).property());
        return this;
    }

    @Override
    public ManyToManyConfigurationBuilder<S, T> isMapped() {
        this.relationship.setMappedBy(hostMappingProperty);
        return this;
    }
}
