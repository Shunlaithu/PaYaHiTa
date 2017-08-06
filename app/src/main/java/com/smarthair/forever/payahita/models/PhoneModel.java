package com.smarthair.forever.payahita.models;

/**
 * Created by Admin on 8/6/2017.
 */

public class PhoneModel {
    private String name;
    private String phone;

    public PhoneModel(String name,String phone) {
        this.name = name;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
