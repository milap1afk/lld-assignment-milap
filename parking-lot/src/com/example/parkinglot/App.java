package com.example.parkinglot;

import com.example.parkinglot.enums.VehicleType;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.Vehicle;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Parking Lot Simulator ===");

        MonolithicParkingLot parkingLot = new MonolithicParkingLot();

        Vehicle car1 = new Vehicle("MH12-1234", VehicleType.CAR);
        Vehicle bike1 = new Vehicle("KA01-0001", VehicleType.MOTORCYCLE);
        Vehicle truck1 = new Vehicle("DL09-9999", VehicleType.TRUCK);

        System.out.println("\n--- Processing Entries ---");
        Ticket ticket1 = parkingLot.processEntry(car1);
        Ticket ticket2 = parkingLot.processEntry(bike1);
        Ticket ticket3 = parkingLot.processEntry(truck1);

        System.out.println("\n--- Processing Checkouts ---");
        if (ticket1 != null) parkingLot.processCheckout(ticket1.getId());
        if (ticket2 != null) parkingLot.processCheckout(ticket2.getId());
        
        System.out.println("\n=== Simulator Finished ===");
    }
}
