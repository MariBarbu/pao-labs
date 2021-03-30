package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Subscription {
    private Library library;
    private Reader reader;
    private int year;
    private int numberBooks = 0; //creste la fiecare imprumut
    private List<Book> books = new ArrayList<Book>();

    public Subscription() {
        this(new Library(), new Reader(), 0, new ArrayList<Book>());
    }

    public Subscription(Library library, Reader reader, int year, List<Book> books) {
        this.library = library;
        this.reader = reader;
        this.year = year;
        this.books = books;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberBooks() {
        return numberBooks;
    }

    public void setNumberBooks(int numberBooks) {
        this.numberBooks = numberBooks;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Library:\n" + library +
                "\nReader:\n" + reader +
                "\nYear: " + year +
                "\nNumberBooks: " + numberBooks +
                "\nBooks:\n" +
                books.stream().map(Book::toString).collect(Collectors.joining("\n"));
    }
}
