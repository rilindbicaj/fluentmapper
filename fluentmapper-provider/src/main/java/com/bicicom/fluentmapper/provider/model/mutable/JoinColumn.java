package com.bicicom.fluentmapper.provider.model.mutable;

import com.bicicom.fluentmapper.provider.model.ReadonlyJoinColumn;

public class JoinColumn extends Column implements ReadonlyJoinColumn {

    private String referencedColumnName;

    @Override
    public String getReferencedColumnName() {
        return referencedColumnName;
    }

    public void setReferencedColumnName(String referencedColumnName) {
        this.referencedColumnName = referencedColumnName;
    }

}
