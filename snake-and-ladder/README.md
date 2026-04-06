Design Snake and Ladder (Refactoring)
=====================================

## Context
Snake and Ladder is a classic board game. The board consists of cells from 1 to 100. There are snakes and ladders on the board. Each snake has a head and a tail. If a player reaches a cell with a snake's head, they drop down to the tail. Similarly, if they reach a ladder's bottom, they climb to the top. Players take turns rolling a standard 6-sided dice to move forward. The first player to reach cell 100 wins.

## Narrative (Current Code)
A beginner developer has created a working prototype of the game in `MonolithicGame`.
- **Tight Coupling:** The board, the players, the dice, and the game loop are completely intertwined in `MonolithicGame`.
- **Unscalable:** If the company wants to introduce a multi-dice system (e.g., rolling two dice), or change the board size to 200, the core game loop would break.
- **Data Anemia:** The concepts of "Snake" and "Ladder" don't exist. They are just a single flat `HashMap` representing jump destinations.

## Your Task
Refactor the system using SOLID principles and Object-Oriented Design!

### Requirements:
1. **Component Abstraction:** 
   - Define distinct classes: `Board`, `Dice`, `Player`, and `Jumper` (which can be a base class/interface for `Snake` and `Ladder`).

2. **Decoupled Game Loop:**
   - The game loop should only orchestrate the flow. It should tell the `Player` to roll a `Dice`, then ask the `Board` to calculate the final position dynamically.

3. **Pluggability:**
   - Design the `Dice` component so that providing a 12-sided dice or rolling multiple dice would be simply plugging in a new `Dice` implementation.

## Acceptance Criteria
- Extract out the raw `Map<Integer, Integer>` logic into dedicated `Snake` and `Ladder` entities.
- Completely dismantle `MonolithicGame` into independent classes.
- Ensure the game loop handles taking turns seamlessly up to exactly cell 100 without overshooting.

## Build & Run
```bash
cd snake-and-ladder/src
javac com/example/snakeandladder/**/*.java com/example/snakeandladder/*.java
java com.example.snakeandladder.App
```
