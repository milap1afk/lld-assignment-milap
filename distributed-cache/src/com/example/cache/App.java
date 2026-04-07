package com.example.cache;

import com.example.cache.db.Database;
import com.example.cache.db.MockDatabase;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Distributed Cache System Simulator ===");

        Database mockDb = new MockDatabase();
        // 2 nodes, capacity 2 per node
        MonolithicDistributedCache cache = new MonolithicDistributedCache(2, 2, mockDb);

        System.out.println("\n--- Testing GET for user1 (Miss) ---");
        System.out.println("Result: " + cache.get("user1"));
        
        System.out.println("\n--- Testing GET for user1 again (Hit) ---");
        System.out.println("Result: " + cache.get("user1"));

        System.out.println("\n--- Testing PUT to trigger Eviction ---");
        cache.put("userA", "Alpha");
        cache.put("userB", "Beta");
        cache.put("userC", "Charlie"); // May trigger eviction depending on modulo distribution
        cache.put("userD", "Delta");
        
        System.out.println("\n--- Simulating finished ---");
    }
}
