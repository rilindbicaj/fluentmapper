package dev.bici.fluentmapper.provider.testutils.mappings;

import dev.bici.fluentmapper.core.EntityMapper;
import dev.bici.fluentmapper.model.builder.ModelBuilder;
import dev.bici.fluentmapper.provider.testutils.models.Address;
import dev.bici.fluentmapper.provider.testutils.models.User;

public class AddressMapping implements EntityMapper<Address> {
    @Override
    public void configure(ModelBuilder<Address> modelBuilder) {
        modelBuilder.hasKey(Address::getId)
                .toColumn("address_id", config -> {
                    config.withLength(120).isRequired();
                });

        modelBuilder.hasMany(Address::getUsers)
                .withOne(User::getAddress)
                .mappedBy(User::getAddress);
    }
}
