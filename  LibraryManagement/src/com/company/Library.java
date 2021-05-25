package com.company;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private int id;
    private String name;
    private String address;
//    private List<Section> sections = new ArrayList<Section>();


    public Library() {
        this(0, "", "");
    }

    public Library(int id, String name, String adress) {
        this.id = id;
        this.name = name;
        this.address = adress;
//        this.sections = sections;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public List<Section> getSections() {
//        return sections;
//    }
//
//    public void setSections(List<Section> sections) {
//        this.sections = sections;
//    }

    @Override
    public String toString() {
        return  name + " with address " + address;
    }
}
