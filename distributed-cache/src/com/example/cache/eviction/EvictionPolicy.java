package com.example.cache.eviction;

import com.example.cache.models.CacheRecord;
import java.util.Map;

public interface EvictionPolicy {
    void evict(Map<String, CacheRecord> dataStore);
}
