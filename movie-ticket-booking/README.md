Movie Ticket Booking System (Refactoring)
-----------------------------------------
Narrative (Current Code)
A simple application that allows users to view movies, select seats, and book tickets.
Right now, the system suffers from tight coupling, concurrency issues, and mixed responsibilities.

Problems in the current design:
- No concurrency control: multiple user requests could potentially book the same seat.
- Kitchen sink class: The BookingSystem class does everything - finding seats, payment processing, and confirmation generation.
- Hardcoded pricing: Pricing logic is hardcoded without separation for different seat types.
- Clients depend directly on concrete classes for payments.

Your Task
1) Use SOLID principles to split responsibilities (e.g., separate PaymentProcessor, SeatManager, BookingService).
2) Ensure that the code simulates solving concurrency when booking seats (handling state appropriately).
3) Apply design patterns where applicable:
   - State pattern for Seat (Available, Reserved, Booked, OutOfOrder).
   - Strategy pattern for pricing based on seat type (e.g., Regular vs VIP).

Acceptance Criteria
- A seat cannot be double-booked.
- Code must be loosely coupled and easy to test.
- Output remains easy to verify from console logs.

Hints
- Define an interface: PaymentStrategy { boolean pay(double amount); }
- Let Seat have a state or synchronized status updates.
- Separate components for search, booking, and payment.

Build & Run
  cd movie-ticket-booking/src
  javac com/example/booking/*.java
  java com.example.booking.App

Repo intent
This is a refactoring assignment: the starter code works, but violates single-responsibility and open-closed principles.
Students should refactor the design into a robust movie ticket booking system.
