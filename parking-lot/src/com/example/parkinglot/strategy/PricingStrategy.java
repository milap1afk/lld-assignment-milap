package com.example.parkinglot.strategy;

import com.example.parkinglot.models.Ticket;

public interface PricingStrategy {
    // TODO: Extract logic from MonolithicParkingLot's processCheckout to an implementation
    double calculatePrice(Ticket ticket);
}
