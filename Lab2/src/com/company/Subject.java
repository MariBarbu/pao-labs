package com.company;

public class Subject {
    private Room room;
    private Integer noOfStudents;
    private Person teacher;


    public Subject() {
        this.room = new Room();
        this.noOfStudents = 0;
        this.teacher = new Person();
    }

    public Subject(Room room, Integer noOfStudents, Person teacher) {
        this.room = room;
        this.noOfStudents = noOfStudents;
        this.teacher = teacher;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Integer getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(Integer noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "room=" + room +
                ", noOfStudents=" + noOfStudents +
                ", teacher=" + teacher +
                '}';
    }


}
