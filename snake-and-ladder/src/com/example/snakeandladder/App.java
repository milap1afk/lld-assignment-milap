package com.example.snakeandladder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Snake & Ladder Simulator ===");

        // Data Models Setup (Tightly packed manually)
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(14, 7);
        snakes.put(31, 26);
        snakes.put(78, 39);
        snakes.put(99, 21);

        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(3, 22);
        ladders.put(8, 26);
        ladders.put(28, 77);
        ladders.put(50, 91);

        Queue<String> players = new LinkedList<>();
        players.add("Alice");
        players.add("Bob");

        MonolithicGame game = new MonolithicGame(players, snakes, ladders);
        game.startGame();
    }
}
