Design a Pen (Refactoring)
==========================

## Context
"Design a Pen" is a classic Low Level Design (LLD) interview question. It tests your ability to model real-world objects using Object-Oriented Principles, separating what varies from what stays the same, and correctly using abstraction and interfaces.

Pens come in many varieties (Ball Pen, Gel Pen, Fountain Pen). They have different types of ink, different mechanisms for writing, and some can be refilled while others are use-and-throw.

## Narrative (Current Code)
A simplistic string-based application exists in `MonolithicPen`. 
- **Tight Coupling and Kitchen Sink:** `MonolithicPen` attempts to represent every possible type of pen. It uses messy `if/else` checks based on a `PenType` enum to figure out how to write and whether it can be refilled.
- **No Abstraction:** Everything is grouped into a singular entity instead of breaking the Pen down into components (Ink, Nib, Refill, Body).
- **Violation of Open/Closed Principle:** Adding a new pen type (like a "Marker") requires modifying the core class.

## Your Task
Refactor the system using SOLID principles and Design Patterns!

### Requirements:
1. **Component Abstraction:** 
   - A Pen should be composed of components. Define classes/interfaces for `Refill`, `Nib`, and `Ink`. Note that Fountain pens don't have standard "Refills" (they take ink directly or via cartridges), whereas Gel and Ball pens use Refills containing both Nib and Ink.

2. **Writing Strategies:**
   - How a pen writes differs by type (smoothness, smudging). Implement a Strategy Pattern using the `Writable` interface to delegate the act of writing.

3. **Behaviors as Interfaces:**
   - Some pens are `Refillable`, others are use-and-throw. Ensure there are corresponding interfaces so a client knows if a pen accepts a new refill. 

4. **Creation via Factory (Optional / Stretch Goal):**
   - Use a Factory or Builder pattern to construct complex pens dynamically without exposing the internal construction details to the Client.

## Acceptance Criteria
- Extract out the `if/else` logic into polymorphic behavior using distinct Pen subclasses (`BallPen`, `FountainPen`, `GelPen`).
- A `Refill` or `Ink` module accurately depletes as the pen writes.
- The `MonolithicPen` class is entirely dissolved.
- `App.java` runs simulations with different writing strategies cleanly.

## Build & Run
```bash
cd design-a-pen/src
javac com/example/pen/**/*.java com/example/pen/*.java
java com.example.pen.App
```
