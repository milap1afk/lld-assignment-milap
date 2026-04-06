package com.example.snakeandladder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class MonolithicGame {
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;
    private Queue<String> players;
    private Map<String, Integer> playerPositions;
    private int boardSize = 100;

    public MonolithicGame(Queue<String> players, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.players = players;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playerPositions = new HashMap<>();

        for (String player : players) {
            playerPositions.put(player, 0);
        }
    }

    // Violates SRP: This class rolls the dice natively, handles maps natively, 
    // loops for victory, and processes movement.
    public void startGame() {
        Random random = new Random();
        System.out.println("Starting Snake and Ladder Game...");

        boolean isGameWon = false;

        while (!isGameWon) {
            String currentPlayer = players.poll();
            int currentPos = playerPositions.get(currentPlayer);

            // Roll Dice natively
            int diceValue = random.nextInt(6) + 1;
            int newPosition = currentPos + diceValue;

            if (newPosition > boardSize) {
                // Cannot move
                System.out.println(currentPlayer + " rolled a " + diceValue + " and stays at " + currentPos + " (Needs exact roll)");
                players.offer(currentPlayer);
                continue;
            } else if (newPosition == boardSize) {
                System.out.println(currentPlayer + " rolled a " + diceValue + " and safely landed on 100!");
                System.out.println(currentPlayer + " wins the game!");
                isGameWon = true;
                break;
            }

            // Check if Snake or Ladder
            if (snakes.containsKey(newPosition)) {
                System.out.println(currentPlayer + " rolled a " + diceValue + " but was bitten by a SNAKE at " + newPosition + ". Dropping to " + snakes.get(newPosition));
                newPosition = snakes.get(newPosition);
            } else if (ladders.containsKey(newPosition)) {
                System.out.println(currentPlayer + " rolled a " + diceValue + " and found a LADDER at " + newPosition + "! Climbing to " + ladders.get(newPosition));
                newPosition = ladders.get(newPosition);
            } else {
                System.out.println(currentPlayer + " rolled a " + diceValue + " and moved to " + newPosition);
            }

            playerPositions.put(currentPlayer, newPosition);
            players.offer(currentPlayer);
        }
    }
}
