Elevator System Design (Refactoring)
------------------------------------
Narrative (Current Code)
A simple elevator simulation that takes a lift to requested floors.
Right now, the system suffers from tight coupling, mixed responsibilities, and poor extensibility for new scheduling logic.

Problems in the current design:
- Kitchen sink class: The Elevator class not only models the physical lift (current floor, doors) but also decides the complex scheduling algorithm (which floor to go to next).
- No State Pattern: The elevator’s state (Idle, Moving Up, Moving Down) is handled via complex if/else checks.
- Hardcoded Request Logic: The strategy for handling floor requests is difficult to swap without altering the Elevator class directly.

Your Task
1) Use SOLID principles to split responsibilities.
   - Separate the scheduling algorithm into its own component (e.g., RequestDispatcher or SchedulingStrategy).
2) Introduce the State pattern for the Elevator (e.g., IdleState, MovingUpState, MovingDownState) to replace large switch/if statements.
3) Ensure adding a new strategy (like Shortest-Seek-Time-First) doesn't require modifying the Elevator's core hardware simulation code.

Acceptance Criteria
- The Elevator class correctly offloads the decision of "where to go next" to a separate scheduler/controller.
- Requests made from inside the elevator vs. from floor buttons are cleanly handled.
- Code must be loosely coupled and easy to test.

Build & Run
  cd elevator-system/src
  javac com/example/elevator/*.java
  java com.example.elevator.App

Repo intent
This is a design and refactoring assignment. The starter code merges the controller and the physical elevator models.
Students should refactor the design into a scalable elevator control system.
