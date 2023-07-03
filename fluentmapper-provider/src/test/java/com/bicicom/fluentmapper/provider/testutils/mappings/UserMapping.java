package com.bicicom.fluentmapper.provider.testutils.mappings;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.model.builder.ModelBuilder;
import com.bicicom.fluentmapper.provider.testutils.models.Address;
import com.bicicom.fluentmapper.provider.testutils.models.User;

public class UserMapping implements EntityMapper<User> {
    @Override
    public void configure(ModelBuilder<User> modelBuilder) {
        modelBuilder.hasKey(User::getId)
                .toColumn("user_id", c -> c.isUnique().withLength(12));

        modelBuilder.hasOne(User::getAddress)
                .withMany(Address::getUsers)
                .hasForeignKey("fk_address_id");
    }
}
