package com.example.cache.db;

import java.util.HashMap;
import java.util.Map;

public class MockDatabase implements Database {
    private Map<String, String> persistentStore = new HashMap<>();

    public MockDatabase() {
        persistentStore.put("user1", "Alice");
        persistentStore.put("user2", "Bob");
        persistentStore.put("user3", "Charlie");
    }

    @Override
    public String readFromDb(String key) {
        System.out.println("[DB] Reading " + key + " from database...");
        // Simulating delay
        try { Thread.sleep(500); } catch (Exception ignored) {}
        return persistentStore.get(key);
    }

    @Override
    public void writeToDb(String key, String value) {
        System.out.println("[DB] Writing " + key + " to database.");
        persistentStore.put(key, value);
    }
}
