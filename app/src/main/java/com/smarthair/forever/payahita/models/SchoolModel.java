package com.smarthair.forever.payahita.models;

/**
 * Created by Admin on 8/6/2017.
 */

public class SchoolModel {
    private String name;
    private String location;
    private String founder;
    private String phone;
    private String description;

    public SchoolModel(String name, String location, String founder, String phone, String description) {
        this.name = name;
        this.location = location;
        this.founder = founder;
        this.phone = phone;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
