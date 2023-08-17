package com.bicicom.fluentmapper.provider.benchmarks.mappings;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.model.builder.ModelBuilder;
import com.bicicom.fluentmapper.provider.benchmarks.models.User;
import com.bicicom.fluentmapper.provider.benchmarks.models.UserInfo;

public class UserInfoMapping implements EntityMapper<UserInfo> {
    @Override
    public void configure(ModelBuilder<UserInfo> modelBuilder) {
        modelBuilder.toTable("user_info_table");

        modelBuilder.hasKey(UserInfo::getId)
                .toColumn("user_info_id");

        modelBuilder.property(UserInfo::getParentName)
                .toColumn("parent_name");
        modelBuilder.property(UserInfo::getAge)
                .toColumn("user_age");

        modelBuilder.hasOne(UserInfo::getUser)
                .withOne(User::getUserInfo)
                .isMapped();
    }
}
