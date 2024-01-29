package dev.bici.fluentmapper.provider.builder;

import dev.bici.fluentmapper.model.builder.JoinTableConfigurationBuilder;
import dev.bici.fluentmapper.provider.model.JoinColumn;
import dev.bici.fluentmapper.provider.model.JoinTable;

public class JoinTableBuilder implements JoinTableConfigurationBuilder {

    private final JoinTable joinTable;

    public JoinTableBuilder(JoinTable joinTable) {
        this.joinTable = joinTable;
    }

    @Override
    public JoinTableConfigurationBuilder withForeignKey(String foreignKey, String referencedPrimaryKey) {
        var joinColumn = new JoinColumn();
        joinColumn.setName(foreignKey);
        joinColumn.setReferencedColumnName(referencedPrimaryKey);

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
    public JoinTableConfigurationBuilder withInverseForeignKey(String foreignKey, String referencedPrimaryKey) {
        var joinColumn = new JoinColumn();
        joinColumn.setName(foreignKey);
        joinColumn.setReferencedColumnName(referencedPrimaryKey);

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
