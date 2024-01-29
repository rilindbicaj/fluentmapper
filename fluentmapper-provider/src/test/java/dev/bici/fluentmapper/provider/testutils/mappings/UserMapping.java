package dev.bici.fluentmapper.provider.testutils.mappings;

import dev.bici.fluentmapper.core.EntityMapper;
import dev.bici.fluentmapper.model.builder.ModelBuilder;
import dev.bici.fluentmapper.provider.testutils.models.Address;
import dev.bici.fluentmapper.provider.testutils.models.User;

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
