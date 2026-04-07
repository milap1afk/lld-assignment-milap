package com.example.ratelimiter.algorithms;

public class SlidingWindowCounter implements RateLimitingAlgorithm {
    // TODO: Implement using a queue or sorted set layout per Key. Handle thread-safety!

    @Override
    public boolean allowRequest(String key) {
        return true;
    }
}
