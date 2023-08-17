package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.model.builder.JoinTableConfigurationBuilder;
import com.bicicom.fluentmapper.provider.model.JoinColumn;
import com.bicicom.fluentmapper.provider.model.JoinTable;

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

        // TODO - something about collections being named in singular
        joinTable.getJoinColumn().add(joinColumn);

        return this;
    }

    @Override
    public JoinTableConfigurationBuilder withForeignKey(String foreignKey) {
        var joinColumn = new JoinColumn();
        joinColumn.setName(foreignKey);
        joinColumn.setReferencedColumnName(foreignKey);

        joinTable.getJoinColumn().add(joinColumn);

        return this;
    }

    @Override
    public JoinTableConfigurationBuilder withInverseForeignKey(String foreignKey, String joinTableKey) {
        var joinColumn = new JoinColumn();
        joinColumn.setName(foreignKey);
        joinColumn.setReferencedColumnName(joinTableKey);

        joinTable.getInverseJoinColumn().add(joinColumn);

        return this;
    }

    @Override
    public JoinTableConfigurationBuilder withInverseForeignKey(String foreignKey) {
        var joinColumn = new JoinColumn();
        joinColumn.setName(foreignKey);
        joinColumn.setReferencedColumnName(foreignKey);

        joinTable.getInverseJoinColumn().add(joinColumn);

        return this;
    }
}
