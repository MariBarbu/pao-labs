package com.company;

public class Librarian extends Employee{
    private Section section;

    public Librarian() {
        super();
        this.section = new Section();
    }

    public Librarian(String name, int hours, String birthDate, Library library, Section section) {
        super(name, hours, birthDate, library);
        this.section = section;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", section: " + section;
    }
}
