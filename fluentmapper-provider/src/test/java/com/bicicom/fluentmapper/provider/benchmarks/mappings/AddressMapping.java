package com.bicicom.fluentmapper.provider.benchmarks.mappings;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.model.builder.ModelBuilder;
import com.bicicom.fluentmapper.provider.benchmarks.models.Address;
import com.bicicom.fluentmapper.provider.benchmarks.models.User;


public class AddressMapping implements EntityMapper<Address> {
    @Override
    public void configure(ModelBuilder<Address> modelBuilder) {
        modelBuilder.hasKey(Address::getId)
                .toColumn("address_id");

        modelBuilder.property(Address::getName)
                .toColumn("address_name");

        modelBuilder.toTable("address_table");

        modelBuilder.hasMany(Address::getUsers)
                .withMany(User::getAddresses)
                .isMapped();
    }
}
