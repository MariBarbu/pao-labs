package com.company;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private int id;
    private String name;
    private int floor;
    private int library_id;
//    private List<Book> books = new ArrayList<Book>();

    public Section(){
        this(0, "", 0, 0);
    }
    public Section(int id, String name, int floor, int library_id) {
        this.id = id;
        this.name = name;
        this.floor = floor;
//        this.library = library;
//        this.books = books;
        this.library_id = library_id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

//
//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }

    @Override
    public String toString() {
        return  name + ", floor: " + floor +
                ", library: " + library_id;
    }
}
