package dev.bici.fluentmapper.provider.builder;

import dev.bici.fluentmapper.model.builder.ManyToOneConfigurationBuilder;
import dev.bici.fluentmapper.provider.model.JoinColumn;
import dev.bici.fluentmapper.provider.model.ManyToOne;

public class ManyToOneBuilder<S, T> extends BaseModelBuilder implements ManyToOneConfigurationBuilder<S, T> {

    private final ManyToOne relationship;

    ManyToOneBuilder(ManyToOne relationship) {
        this.relationship = relationship;
    }

    @Override
    public ManyToOneConfigurationBuilder<S, T> hasForeignKey(String foreignKey) {
        var joinColumn = new JoinColumn();

        joinColumn.setName(foreignKey);
        relationship.getJoinColumn().add(joinColumn);

        return this;
    }

}
