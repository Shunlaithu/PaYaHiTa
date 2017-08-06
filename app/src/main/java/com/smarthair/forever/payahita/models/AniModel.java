package com.smarthair.forever.payahita.models;

/**
 * Created by Admin on 8/6/2017.
 */

public class AniModel {
    private String name;
    private String location;
    private String phone;


    public AniModel(String name, String location, String phone) {
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
