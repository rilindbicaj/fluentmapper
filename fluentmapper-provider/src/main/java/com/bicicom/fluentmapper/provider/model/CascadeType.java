package com.bicicom.fluentmapper.provider.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cascade-type", propOrder = {
        "cascadeAll",
        "cascadePersist",
        "cascadeMerge",
        "cascadeRemove",
        "cascadeRefresh",
        "cascadeDetach"
})
public class CascadeType {

    @XmlElement(name = "cascade-all")
    protected EmptyType cascadeAll;
    @XmlElement(name = "cascade-persist")
    protected EmptyType cascadePersist;
    @XmlElement(name = "cascade-merge")
    protected EmptyType cascadeMerge;
    @XmlElement(name = "cascade-remove")
    protected EmptyType cascadeRemove;
    @XmlElement(name = "cascade-refresh")
    protected EmptyType cascadeRefresh;
    @XmlElement(name = "cascade-detach")
    protected EmptyType cascadeDetach;

    public EmptyType getCascadeAll() {
        return cascadeAll;
    }

    public void setCascadeAll(EmptyType value) {
        this.cascadeAll = value;
    }

    public EmptyType getCascadePersist() {
        return cascadePersist;
    }

    public void setCascadePersist(EmptyType value) {
        this.cascadePersist = value;
    }

    public EmptyType getCascadeMerge() {
        return cascadeMerge;
    }

    public void setCascadeMerge(EmptyType value) {
        this.cascadeMerge = value;
    }

    public EmptyType getCascadeRemove() {
        return cascadeRemove;
    }

    public void setCascadeRemove(EmptyType value) {
        this.cascadeRemove = value;
    }

    public EmptyType getCascadeRefresh() {
        return cascadeRefresh;
    }

    public void setCascadeRefresh(EmptyType value) {
        this.cascadeRefresh = value;
    }

    public EmptyType getCascadeDetach() {
        return cascadeDetach;
    }

    public void setCascadeDetach(EmptyType value) {
        this.cascadeDetach = value;
    }

}
