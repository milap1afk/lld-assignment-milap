package com.example.parkinglot.strategy;

import com.example.parkinglot.models.Vehicle;

public interface FindingStrategy {
    // TODO: A scalable find mechanism replacing fixed integer counts
    boolean hasAvailableSpot(Vehicle vehicle);
}
