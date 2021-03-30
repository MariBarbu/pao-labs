package com.company;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private String name;
    private int floor;
    private Library library;
    private List<Book> books = new ArrayList<Book>();

    public Section(){
        this("", 0, new Library(), new ArrayList<Book>());
    }
    public Section(String name, int floor, Library library, List<Book> books) {
        this.name = name;
        this.floor = floor;
        this.library = library;
        this.books = books;
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

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return  name + ", floor: " + floor +
                ", library: " + library;
    }
}
