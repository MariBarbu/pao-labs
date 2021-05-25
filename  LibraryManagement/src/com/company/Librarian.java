package com.company;

public class Librarian extends Employee{
    private int section_id;

    public Librarian() {
        super();
        this.section_id = 0;
    }

    public Librarian(int id, String name, int hours, String birthDate, int library_id, int section_id) {
        super(id, name, hours, birthDate, library_id);
        this.section_id = section_id;
    }

    public int getSection_id() {
        return section_id;
    }

    public void setSection_id(int section_id) {
        this.section_id = section_id;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", section: " + section_id;
    }
}
