package com.bicicom.fluentmapper.provider.builder;

import com.bicicom.fluentmapper.model.builder.ManyToOneConfigurationBuilder;
import com.bicicom.fluentmapper.provider.model.mutable.JoinColumn;
import com.bicicom.fluentmapper.provider.model.mutable.ManyToOneRelationship;

public class ManyToOneBuilder<S, T> extends BaseModelBuilder implements ManyToOneConfigurationBuilder<S, T> {

    private final ManyToOneRelationship relationship;

    ManyToOneBuilder(ManyToOneRelationship relationship) {
        this.relationship = relationship;
    }

    @Override
    public ManyToOneConfigurationBuilder<S, T> hasForeignKey(String foreignKey) {
        var joinColumn = new JoinColumn();

        joinColumn.setName(foreignKey);
        relationship.setJoinColumn(joinColumn);

        return this;
    }

}
