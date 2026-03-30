package com.example.elevator;

public class ElevatorRequest {
    private int destinationFloor;

    public ElevatorRequest(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }
}
