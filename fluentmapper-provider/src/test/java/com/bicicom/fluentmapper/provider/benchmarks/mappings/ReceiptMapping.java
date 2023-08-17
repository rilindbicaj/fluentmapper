package com.bicicom.fluentmapper.provider.benchmarks.mappings;

import com.bicicom.fluentmapper.core.EntityMapper;
import com.bicicom.fluentmapper.model.builder.ModelBuilder;
import com.bicicom.fluentmapper.provider.benchmarks.models.Receipt;
import com.bicicom.fluentmapper.provider.benchmarks.models.User;

public class ReceiptMapping implements EntityMapper<Receipt> {
    @Override
    public void configure(ModelBuilder<Receipt> modelBuilder) {
        modelBuilder.toTable("receipts");

        modelBuilder.hasKey(Receipt::getId)
                .toColumn("receipt_id");

        modelBuilder.property(Receipt::getTitle)
                .toColumn("receipt_title");

        modelBuilder.hasOne(Receipt::getUser)
                .withMany(User::getReceipts)
                .hasForeignKey("owning_user_id");
    }
}
