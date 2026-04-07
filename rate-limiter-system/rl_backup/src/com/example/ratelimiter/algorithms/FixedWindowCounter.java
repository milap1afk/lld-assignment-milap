package com.example.ratelimiter.algorithms;

public class FixedWindowCounter implements RateLimitingAlgorithm {
    // TODO: Maintain a map of Key -> Counter/Timestamp. Handle thread-safety!
    
    @Override
    public boolean allowRequest(String key) {
        return true; 
    }
}
