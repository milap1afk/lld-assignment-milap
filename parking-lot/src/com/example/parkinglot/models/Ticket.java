package com.example.parkinglot.models;

public class Ticket {
    private String id;
    private Vehicle vehicle;
    private long entryTime;
    
    // Typically, in a refactored version, a Ticket would also know the ParkingSpot it assigns.
    public Ticket(String id, Vehicle vehicle, long entryTime) {
        this.id = id;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public long getEntryTime() {
        return entryTime;
    }
}
