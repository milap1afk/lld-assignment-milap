package com.example.ratelimiter.config;

// simple POJO configuration object
public class RateLimitConfig {
    private int maxRequests;
    private long timeWindowInMillis;

    public RateLimitConfig(int maxRequests, long timeWindowInMillis) {
        this.maxRequests = maxRequests;
        this.timeWindowInMillis = timeWindowInMillis;
    }

    public int getMaxRequests() {
        return maxRequests;
    }

    public long getTimeWindowInMillis() {
        return timeWindowInMillis;
    }
}
