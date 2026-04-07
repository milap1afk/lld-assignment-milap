package com.example.ratelimiter.algorithms;

public interface RateLimitingAlgorithm {
    boolean allowRequest(String key);
}
