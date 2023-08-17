package com.bicicom.fluentmapper.provider.benchmarks.mappings;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.model.builder.ModelBuilder;
import com.bicicom.fluentmapper.provider.benchmarks.models.Address;
import com.bicicom.fluentmapper.provider.benchmarks.models.Receipt;
import com.bicicom.fluentmapper.provider.benchmarks.models.User;
import com.bicicom.fluentmapper.provider.benchmarks.models.UserInfo;


public class UsersMapping implements EntityMapper<User> {

    @Override
    public void configure(ModelBuilder<User> model) {
        model.hasKey(User::getId)
                .toColumn("user_id");

        model.property(User::getName)
                .toColumn("user_name");

        model.toTable("user_table")
                .withSchema("public");

        model.hasMany(User::getAddresses)
                .withMany(Address::getUsers)
                .joinOnTable("users_addresses")
                .withForeignKey("jointable_user_id", "user_id") //reverse this in code
                .withInverseForeignKey("address_id");

        model.hasOne(User::getUserInfo)
                .withOne(UserInfo::getUser)
                .hasForeignKey("user_info_id");

        model.hasMany(User::getReceipts)
                .withOne(Receipt::getUser);
    }
}
