package com.example.elevator;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Elevator System Simulator ===");
        
        Elevator elevator = new Elevator(0); // Starting at ground floor
        
        System.out.println("User at Floor 5 requests to go down...");
        elevator.requestFloor(5);
        
        System.out.println("User inside elevator presses 2...");
        elevator.requestFloor(2);
        
        System.out.println("Simulating elevator movement...");
        elevator.runSimulation();
    }
}
