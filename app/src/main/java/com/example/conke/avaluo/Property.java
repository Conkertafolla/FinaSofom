package com.example.conke.avaluo;

/**
 * Created by conke on 17/03/2019.
 */

public class Property {
    private String nameReputable;
    private String nameOferent;
    private String address;
    private String start;
    private String end;
    private int rooms;
    private int floors;
    private int bathrooms;
    private boolean parking;


    public Property(String nameReputable, String nameOferent, String address, String start, String end, int rooms, int floors, int bathrooms, boolean parking) {
        this.nameReputable = nameReputable;
        this.nameOferent = nameOferent;
        this.address = address;
        this.start = start;
        this.end = end;
        this.rooms = rooms;
        this.floors = floors;
        this.bathrooms = bathrooms;
        this.parking = parking;
    }

    public Property() {
    }

    public String getNameReputable() {
        return nameReputable;
    }

    public void setNameReputable(String nameReputable) {
        this.nameReputable = nameReputable;
    }

    public String getNameOferent() {
        return nameOferent;
    }

    public void setNameOferent(String nameOferent) {
        this.nameOferent = nameOferent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }
}
