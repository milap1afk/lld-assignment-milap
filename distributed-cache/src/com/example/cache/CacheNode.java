package com.example.cache;

import com.example.cache.models.CacheRecord;
import java.util.HashMap;
import java.util.Map;

// Basic placeholder node. In the refactored version, this should ideally utilize the EvictionPolicy internally.
public class CacheNode {
    private String nodeId;
    private int capacity;
    // Public map for bad design access later
    public Map<String, CacheRecord> dataStore;

    public CacheNode(String nodeId, int capacity) {
        this.nodeId = nodeId;
        this.capacity = capacity;
        this.dataStore = new HashMap<>();
    }

    public String getNodeId() {
        return nodeId;
    }

    public int getCapacity() {
        return capacity;
    }
}
