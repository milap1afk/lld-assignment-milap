package com.example.booking;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Movie Ticket Booking System ===");
        
        BookingSystem system = new BookingSystem();
        system.initialize();

        System.out.println("User 1 tries to book Seat 1A...");
        User u1 = new User("Alice");
        boolean success1 = system.bookTicket(u1, "1A", "CreditCard");
        System.out.println("Booking Success for Alice: " + success1);

        System.out.println("User 2 tries to book Seat 1A immediately after...");
        User u2 = new User("Bob");
        boolean success2 = system.bookTicket(u2, "1A", "UPI");
        System.out.println("Booking Success for Bob: " + success2);
        
        System.out.println("System current status:");
        system.printStatus();
    }
}
