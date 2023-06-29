package com.bicicom.fluentmapper.provider.testutils.models;

import java.util.List;

public class Address {
    public int id;
    public String name;
    public List<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUser(List<User> users) {
        this.users = users;
    }
}
