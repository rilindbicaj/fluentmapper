package com.bicicom.fluentmapper.model.builder;

public interface JoinColumnConfigurationBuilder extends ColumnConfigurationBuilder {

    JoinColumnConfigurationBuilder onEntity(String referencedEntity);

    JoinColumnConfigurationBuilder withLength(int length);

    JoinColumnConfigurationBuilder isRequired();

    JoinColumnConfigurationBuilder isRequired(boolean value);

    JoinColumnConfigurationBuilder isUnique();

    JoinColumnConfigurationBuilder isUnique(boolean value);

}
