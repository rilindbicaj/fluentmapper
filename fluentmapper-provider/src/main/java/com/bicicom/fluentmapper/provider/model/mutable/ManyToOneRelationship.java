package com.bicicom.fluentmapper.provider.model.mutable;

// TODO - Do some interface segregation here and remove the unused methods
@Sequence(1)
public final class ManyToOneRelationship extends Relationship {

    @Override
    public String getMappedBy() {
        throw new UnsupportedOperationException();
    }

    public void setMappedBy(String mappedBy) {
        throw new UnsupportedOperationException();
    }

}
