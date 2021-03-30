package com.company;

import java.util.Date;

public class Book {
    private String title;
    private String author;
    private String description;
    private int year;
    private Section section;

    public Book() {
        this.title = "";
        this.author = "";
        this.description = "";
        this.year = 0;
        this.section = new Section();
    }

    public Book(String title, String author, String description, int year, Section section) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.year = year;
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return  "Title " + title + " by " + author + " from " + year + "\nSection: " + section + "\nDescription: "+ description;

    }
}
