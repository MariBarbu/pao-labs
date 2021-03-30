package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lending {

    private Subscription subscription;
    private Librarian librarian;
    private Book book;
    private String returnDate;

    public Lending() {
        this(new Subscription(), new Librarian(), new Book(), "");

    }

    public Lending(Subscription subscription, Librarian librarian, Book book, String returnDate) {
        this.subscription = subscription;
        this.librarian = librarian;
        this.book = book;
        this.returnDate = returnDate;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Lending: " +
                "\n-subscription: " + subscription +
                "\n-librarian: " + librarian +
                "\n-book: " + book +
                "\n-returnDate='" + returnDate;
    }
}
