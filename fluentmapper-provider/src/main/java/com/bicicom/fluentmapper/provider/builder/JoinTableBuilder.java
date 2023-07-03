package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.model.builder.JoinTableConfigurationBuilder;
import com.bicicom.fluentmapper.provider.model.mutable.InverseJoinColumn;
import com.bicicom.fluentmapper.provider.model.mutable.JoinColumn;
import com.bicicom.fluentmapper.provider.model.mutable.JoinTable;

public class JoinTableBuilder implements JoinTableConfigurationBuilder {

    private final JoinTable joinTable;

    public JoinTableBuilder(JoinTable joinTable) {
        this.joinTable = joinTable;
    }

    @Override
    public JoinTableConfigurationBuilder withForeignKey(String foreignKey, String joinTableKey) {
        var joinColumn = new JoinColumn();
        joinColumn.setName(foreignKey);
        joinColumn.setReferencedColumnName(joinTableKey);
        joinTable.setJoinColumn(joinColumn);

        return this;
    }

    @Override
    public JoinTableConfigurationBuilder withForeignKey(String foreignKey) {
        var joinColumn = new JoinColumn();
        joinColumn.setName(foreignKey);
        joinColumn.setReferencedColumnName(foreignKey);
        joinTable.setJoinColumn(joinColumn);

        return this;
    }

    @Override
    public JoinTableConfigurationBuilder withInverseForeignKey(String foreignKey, String joinTableKey) {
        var joinColumn = new InverseJoinColumn();
        joinColumn.setName(foreignKey);
        joinColumn.setReferencedColumnName(joinTableKey);
        joinTable.setInverseJoinColumn(joinColumn);

        return this;
    }

    @Override
    public JoinTableConfigurationBuilder withInverseForeignKey(String foreignKey) {
        var joinColumn = new InverseJoinColumn();
        joinColumn.setName(foreignKey);
        joinColumn.setReferencedColumnName(foreignKey);
        joinTable.setInverseJoinColumn(joinColumn);

        return this;
    }
}
