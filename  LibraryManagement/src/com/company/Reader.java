package com.company;

public class Reader {
    private String name;
    private String address;


    public Reader() {
        this.name = "";
        this.address = "";
    }

    public Reader(String name, String adress) {
        this.name = name;
        this.address = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return  name + " with address: " + address;
    }
}
