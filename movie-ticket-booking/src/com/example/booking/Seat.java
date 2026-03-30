package com.example.booking;

public class Seat {
    private String id;
    private String type; // e.g. "Regular", "VIP"
    private double price;
    private boolean isBooked;

    public Seat(String id, String type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.isBooked = false;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        this.isBooked = booked;
    }
}
