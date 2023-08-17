package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.model.builder.ManyToOneConfigurationBuilder;
import com.bicicom.fluentmapper.provider.model.JoinColumn;
import com.bicicom.fluentmapper.provider.model.ManyToOne;

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
