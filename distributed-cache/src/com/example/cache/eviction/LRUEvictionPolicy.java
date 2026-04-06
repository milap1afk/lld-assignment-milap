package com.example.cache.eviction;

import com.example.cache.models.CacheRecord;
import java.util.Map;

public class LRUEvictionPolicy implements EvictionPolicy {
    @Override
    public void evict(Map<String, CacheRecord> dataStore) {
        // TODO: Move the LRU eviction logic from MonolithicDistributedCache here.
    }
}
