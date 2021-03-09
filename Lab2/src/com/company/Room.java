package com.company;

public class Room {
    private int roomNumber;
    private String roomType;
    private String roomFloor;

    public Room() {
        this.roomNumber = 0;
        this.roomType = "Hall";
        this.roomFloor = "Wood";
    }

    public Room(int roomNumber, String roomType, String roomFloor) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomFloor = roomFloor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(String roomFloor) {
        this.roomFloor = roomFloor;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", roomFloor='" + roomFloor + '\'' +
                '}';
    }
}
