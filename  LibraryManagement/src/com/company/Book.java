package com.company;

import java.util.Date;

public class Book {
    private int id;
    private String title;
    private String author;
    private String description;
    private int year;
    private int section_id;


    public Book() {
        this.id = 0;
        this.title = "";
        this.author = "";
        this.description = "";
        this.year = 0;
        this.section_id = 0;
    }

    public Book(int id, String title, String author, String description, int year, int section_id) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.year = year;
        this.section_id = section_id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSection_id() {
        return section_id;
    }

    public void setSection_id(int section_id) {
        this.section_id = section_id;
    }

    @Override
    public String toString() {
        return  "Title " + title + " by " + author + " from " + year + "\nSection: " + section_id + "\nDescription: "+ description;

    }
}
