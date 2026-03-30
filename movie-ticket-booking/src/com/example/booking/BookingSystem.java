package com.example.booking;

import java.util.HashMap;
import java.util.Map;

public class BookingSystem {
    private Map<String, Seat> seats;

    public BookingSystem() {
        this.seats = new HashMap<>();
    }

    public void initialize() {
        seats.put("1A", new Seat("1A", "Regular", 10.0));
        seats.put("1B", new Seat("1B", "VIP", 20.0));
    }

    public boolean bookTicket(User user, String seatId, String paymentMethod) {
        Seat seat = seats.get(seatId);

        if (seat == null) {
            System.out.println("Seat not found!");
            return false;
        }

        // Violates Single Responsibility, Open/Closed principles, and concurrency controls
        // Handles seat state, pricing logic, and payment type mapping directly
        if (!seat.isBooked()) {
            // Simulate processing payment
            boolean paymentSuccess = false;
            double amount = seat.getPrice();
            
            if (seat.getType().equals("VIP")) {
                amount += 5.0; // VIP surcharge hardcoded
            }

            if (paymentMethod.equals("CreditCard")) {
                System.out.println("Processing CreditCard payment for $" + amount);
                paymentSuccess = true;
            } else if (paymentMethod.equals("UPI")) {
                System.out.println("Processing UPI payment for $" + amount);
                paymentSuccess = true;
            } else {
                System.out.println("Unknown payment method.");
            }

            if (paymentSuccess) {
                seat.setBooked(true);
                System.out.println("Ticket booked successfully for " + user.getName() + " on seat " + seatId);
                return true;
            }
        } else {
            System.out.println("Seat " + seatId + " is already booked.");
        }

        return false;
    }

    public void printStatus() {
        for (Seat seat : seats.values()) {
            System.out.println("Seat " + seat.getId() + " - " + (seat.isBooked() ? "Booked" : "Available"));
        }
    }
}
