package com.company;

import java.util.Date;

abstract public class Employee {
    private int id;
    private String name;
    private int hours;
    private String birthDate;
    private int library_id;


    public Employee() {
        this.id = 0;
        this.name = "";
        this.hours = 0;
        this.birthDate = "";
        this.library_id = 0;
    }

    public Employee(int id, String name, int hours, String birthDate, int library_id) {
        this.id = id;
        this.name = name;
        this.hours = hours;
        this.birthDate = birthDate;
        this.library_id = library_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }


    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLibrary_id() {
        return library_id;
    }

    public void setLibrary_id(int library_id) {
        this.library_id = library_id;
    }

    @Override
    public String toString() {
        return name + " born in  " + birthDate  + ", works " + hours + " per day in " + library_id;

    }
}
