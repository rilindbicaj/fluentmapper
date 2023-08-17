package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inheritance")
public class Inheritance {

    @XmlAttribute(name = "strategy")
    protected InheritanceType strategy;

    public InheritanceType getStrategy() {
        return strategy;
    }

    public void setStrategy(InheritanceType value) {
        this.strategy = value;
    }

}
