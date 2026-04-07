package com.example.cache;

import com.example.cache.db.Database;
import com.example.cache.models.CacheRecord;
import java.util.ArrayList;
import java.util.List;

public class MonolithicDistributedCache {
    private List<CacheNode> nodes;
    private Database database;

    public MonolithicDistributedCache(int numNodes, int capacityPerNode, Database database) {
        this.nodes = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            nodes.add(new CacheNode("Node-" + i, capacityPerNode));
        }
        this.database = database;
    }

    public String get(String key) {
        System.out.println("Routing GET request for key: " + key);
        // Hardcoded distribution strategy (Modulo based on hash)
        int nodeIndex = Math.abs(key.hashCode()) % nodes.size();
        CacheNode targetNode = nodes.get(nodeIndex);

        CacheRecord record = targetNode.dataStore.get(key);
        if (record != null) {
            System.out.println("Cache HIT on " + targetNode.getNodeId());
            record.updateAccessTime();
            return record.getValue();
        }

        System.out.println("Cache MISS. Fetching from database...");
        String dbValue = database.readFromDb(key);
        if (dbValue != null) {
            put(key, dbValue);
        }
        return dbValue;
    }

    public void put(String key, String value) {
        System.out.println("Routing PUT request for key: " + key);
        // Hardcoded distribution strategy AGAIN (Violates DRY and SOLID)
        int nodeIndex = Math.abs(key.hashCode()) % nodes.size();
        CacheNode targetNode = nodes.get(nodeIndex);

        // Check if eviction is needed (Hardcoded Capacity and LRU logic)
        if (targetNode.dataStore.size() >= targetNode.getCapacity() && !targetNode.dataStore.containsKey(key)) {
            System.out.println("Capacity reached on " + targetNode.getNodeId() + ". Running LRU Eviction.");
            String lruKey = null;
            long oldestTime = Long.MAX_VALUE;

            for (CacheRecord record : targetNode.dataStore.values()) {
                if (record.getLastAccessedTime() < oldestTime) {
                    oldestTime = record.getLastAccessedTime();
                    lruKey = record.getKey();
                }
            }
            if (lruKey != null) {
                targetNode.dataStore.remove(lruKey);
                System.out.println("Evicted key: " + lruKey);
            }
        }

        // Simulating the DB save as part of the monolithic logic
        database.writeToDb(key, value);
        targetNode.dataStore.put(key, new CacheRecord(key, value));
        System.out.println("Cached " + key + " on " + targetNode.getNodeId());
    }
}
