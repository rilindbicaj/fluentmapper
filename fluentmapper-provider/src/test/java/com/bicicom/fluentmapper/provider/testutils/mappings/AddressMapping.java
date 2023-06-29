package com.bicicom.fluentmapper.provider.testutils.mappings;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.model.builder.ModelBuilder;
import com.bicicom.fluentmapper.provider.testutils.models.Address;
import com.bicicom.fluentmapper.provider.testutils.models.User;

public class AddressMapping implements EntityMapper<Address> {
    @Override
    public void configure(ModelBuilder<Address> modelBuilder) {
        modelBuilder.hasKey(Address::getId)
                .toColumn("address_id", config -> {
                    config.withLength(120).isRequired();
                });

        modelBuilder.hasMany(Address::getUsers)
                .withOne(User::getAddress)
                .joinsOn("address_id");
    }
}
