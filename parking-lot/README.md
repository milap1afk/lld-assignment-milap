Design a Parking Lot (Refactoring)
==================================

## Context
"Design a Parking Lot" is one of the most famous Low Level Design (LLD) questions. A typical parking lot has multiple floors, multiple spots per floor, and spots for different types of vehicles (Motorcycles, Cars, Trucks). Vehicles enter, receive a ticket, and pay upon exit based on duration and vehicle type.

## Narrative (Current Code)
A developer was tasked to quickly build a parking lot manager to get the business running. They wrote `MonolithicParkingLot`.
- **God Class:** `MonolithicParkingLot` manages vehicle entry, checks total capacity implicitly without mapping floors, creates tickets manually, tracks time in simple maps, and handles checkout pricing with hardcoded nested `if/else` ladders.
- **Unscalable Capacity:** It assumes the lot is just a flat array of 'spots' instead of distinguishing between Floors and specific Parking Slots (Handicapped, Compact, Large).
- **Hardcoded Strategies:** Finding the next available spot is a linear scan. Pricing is fixed at naive static rates. If the town introduces surge pricing, the whole class has to be rewritten.

## Your Task
Dismantle the monolith and apply robust Object-Oriented principles.

### Requirements:
1. **Component Abstraction:** 
   - Define missing components such as `ParkingFloor` and `ParkingSpot`.
   - Track proper capacities per vehicle type (e.g., A truck requires a Large spot, a Bike can fit in a Compact spot).

2. **Decoupled Strategies:**
   - Extract the logic that decides *where* to park a vehicle into a `FindingStrategy` interface (e.g., `NearestToElevatorStrategy`, `DefaultDistributionStrategy`).
   - Extract the mathematical logic behind final cost into a `PricingStrategy` (e.g., `HourlyRatePricing`, `FlatFeePricing`).

3. **Pluggability:**
   - The Parking Lot should not care how pricing is computed. It should pass the `Ticket` details to the pricing module and get a cost back.

## Acceptance Criteria
- `MonolithicParkingLot` is completely removed and replaced by a scalable structure.
- Concrete classes implement the `PricingStrategy` and `FindingStrategy` interfaces.
- The entry and exit outputs in `App.java` run smoothly without relying on flat hash maps for raw ticket management.

## Build & Run
```bash
cd parking-lot/src
javac com/example/parkinglot/**/*.java com/example/parkinglot/*.java
java com.example.parkinglot.App
```
