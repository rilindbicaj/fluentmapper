package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generated-value")
public class GeneratedValue {

    @XmlAttribute(name = "strategy")
    protected GenerationType strategy;
    @XmlAttribute(name = "generator")
    protected String generator;

    public GenerationType getStrategy() {
        return strategy;
    }

    public void setStrategy(GenerationType value) {
        this.strategy = value;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String value) {
        this.generator = value;
    }

}
