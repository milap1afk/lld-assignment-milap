package com.example.elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private int currentFloor;
    private Direction direction;
    private List<ElevatorRequest> pendingRequests;

    public Elevator(int startFloor) {
        this.currentFloor = startFloor;
        this.direction = Direction.IDLE;
        this.pendingRequests = new ArrayList<>();
    }

    public void requestFloor(int floor) {
        pendingRequests.add(new ElevatorRequest(floor));
        System.out.println("Added request for floor " + floor);
    }

    // Violates SRP: This class is a physical model of an elevator
    // but also implements simple routing algorithms directly in the core loop.
    public void runSimulation() {
        System.out.println("Starting simulation...");
        
        while (!pendingRequests.isEmpty()) {
            ElevatorRequest nextRequest = pendingRequests.remove(0); // very naive FIFO scheduling
            
            System.out.println("Elevator heading towards floor " + nextRequest.getDestinationFloor());
            
            if (currentFloor < nextRequest.getDestinationFloor()) {
                direction = Direction.UP;
            } else if (currentFloor > nextRequest.getDestinationFloor()) {
                direction = Direction.DOWN;
            } else {
                direction = Direction.IDLE;
            }
            
            // Simulating movement
            while (currentFloor != nextRequest.getDestinationFloor()) {
                if (direction == Direction.UP) {
                    currentFloor++;
                } else if (direction == Direction.DOWN) {
                    currentFloor--;
                }
                System.out.println("Elevator passing floor " + currentFloor);
            }
            
            // Stopped at requested floor
            direction = Direction.IDLE;
            openDoors();
            closeDoors();
            
            System.out.println("Completed request for floor " + currentFloor);
            System.out.println("---");
        }
        
        System.out.println("Elevator is idle at floor " + currentFloor + ". No more requests.");
    }
    
    private void openDoors() {
        System.out.println("Elevator doors opening at floor " + currentFloor);
    }
    
    private void closeDoors() {
        System.out.println("Elevator doors closing at floor " + currentFloor);
    }
}
