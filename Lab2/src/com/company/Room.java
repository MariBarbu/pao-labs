package com.company;

public class Room {
    private int room_number;
    private String room_type;
    private String room_floor;

    public Room() {
        this.room_number = 0;
        this.room_type = "Hall";
        this.room_floor = "Wood";
    }

    public Room(int room_number, String room_type, String room_floor) {
        this.room_number = room_number;
        this.room_type = room_type;
        this.room_floor = room_floor;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getRoom_floor() {
        return room_floor;
    }

    public void setRoom_floor(String room_floor) {
        this.room_floor = room_floor;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_number=" + room_number +
                ", room_type='" + room_type + '\'' +
                ", room_floor='" + room_floor + '\'' +
                '}';
    }


}
