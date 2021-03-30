package com.company;

import java.util.Date;

abstract public class Employee {
    private String name;
    private int hours;
    private String birthDate;
    private Library library;

    public Employee() {
        this.name = "";
        this.hours = 0;
        this.birthDate = "";
        this.library = new Library();
    }

    public Employee(String name, int hours, String birthDate, Library library) {
        this.name = name;
        this.hours = hours;
        this.birthDate = birthDate;
        this.library = library;
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

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public String toString() {
        return name + " born in  " + birthDate  + ", works " + hours + " per day in " + library;

    }
}
