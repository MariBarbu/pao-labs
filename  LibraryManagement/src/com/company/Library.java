package com.company;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private String address;
    private List<Section> sections = new ArrayList<Section>();


    public Library() {
        this("", "", new ArrayList<Section>());
    }

    public Library(String name, String adress, List<Section> sections) {
        this.name = name;
        this.address = adress;
        this.sections = sections;
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

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return  name + " with address " + address;
    }
}
