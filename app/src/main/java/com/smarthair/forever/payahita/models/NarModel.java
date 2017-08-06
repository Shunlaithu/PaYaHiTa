package com.smarthair.forever.payahita.models;


public class NarModel {
    private String name;
    private String location;
    private String founder;
    private String phone;
    private String description;

    public NarModel(String name, String location, String phone) {
        this.name = name;
        this.location = location;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
