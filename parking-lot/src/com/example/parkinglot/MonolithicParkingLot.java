package com.example.parkinglot;

import com.example.parkinglot.enums.VehicleType;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class MonolithicParkingLot {
    
    // Unscalable flat capacity
    private int flatCapacity = 10;
    private int currentOccupied = 0;
    
    private int ticketCounter = 1;
    private Map<String, Ticket> activeTickets = new HashMap<>();

    public Ticket processEntry(Vehicle vehicle) {
        if (currentOccupied >= flatCapacity) {
            System.out.println("Parking Lot is full! Cannot admit " + vehicle.getLicensePlate());
            return null;
        }
        
        System.out.println("Admitting vehicle: " + vehicle.getLicensePlate() + " (" + vehicle.getType() + ")");
        currentOccupied++;
        
        String ticketId = "TKT-" + (ticketCounter++);
        Ticket ticket = new Ticket(ticketId, vehicle, System.currentTimeMillis() - 7200000); // Backdated 2 hours for simulation
        activeTickets.put(ticketId, ticket);
        
        return ticket;
    }

    // Violates SRP and OpenClosed: contains pricing logic explicitly
    public void processCheckout(String ticketId) {
        Ticket ticket = activeTickets.get(ticketId);
        
        if (ticket == null) {
            System.out.println("Invalid ticket ID!");
            return;
        }
        
        long durationMillis = System.currentTimeMillis() - ticket.getEntryTime();
        double hours = (double) durationMillis / 3600000;
        
        double price = 0.0;
        
        if (ticket.getVehicle().getType() == VehicleType.MOTORCYCLE) {
            price = hours * 20.0;
        } else if (ticket.getVehicle().getType() == VehicleType.CAR) {
            price = hours * 50.0;
        } else if (ticket.getVehicle().getType() == VehicleType.TRUCK) {
            price = hours * 100.0;
        }
        
        System.out.printf("Vehicle %s departing. Duration: %.2f hours. Amount Due: $%.2f%n", 
                ticket.getVehicle().getLicensePlate(), hours, price);
        
        activeTickets.remove(ticketId);
        currentOccupied--;
    }
}
