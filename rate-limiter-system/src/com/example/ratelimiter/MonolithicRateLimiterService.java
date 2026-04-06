package com.example.ratelimiter;

import com.example.ratelimiter.config.RateLimitConfig;
import com.example.ratelimiter.exceptions.RateLimitExceededException;
import com.example.ratelimiter.resources.ExternalResourceClient;

import java.util.HashMap;
import java.util.Map;

// Simulates a legacy design mixed with Business Logic and Rate Limiting
public class MonolithicRateLimiterService {
    
    private ExternalResourceClient externalClient;
    private RateLimitConfig config;

    // Horrible: Not thread-safe, memory leak risk, and inextricably linked to fixed window algorithm.
    private Map<String, Integer> requestCounts = new HashMap<>();
    private Map<String, Long> windowStartTimes = new HashMap<>();

    public MonolithicRateLimiterService(ExternalResourceClient externalClient, RateLimitConfig config) {
        this.externalClient = externalClient;
        this.config = config;
    }

    public void processClientRequest(String clientId, boolean needsExternalResource, String payload) {
        System.out.println("Processing API request for client " + clientId);
        
        // Complex business validation logic happens here...
        
        if (!needsExternalResource) {
            System.out.println("No external resource needed for this request. Finished.\n");
            return;
        }

        System.out.println("External resource required. Checking rate limits...");
        
        // This is a tightly coupled Fixed Window logic right inside the service.
        long currentTime = System.currentTimeMillis();
        
        windowStartTimes.putIfAbsent(clientId, currentTime);
        requestCounts.putIfAbsent(clientId, 0);

        long windowStart = windowStartTimes.get(clientId);
        if (currentTime - windowStart >= config.getTimeWindowInMillis()) {
            // Reset the window
            windowStartTimes.put(clientId, currentTime);
            requestCounts.put(clientId, 0);
        }

        int currentCount = requestCounts.get(clientId);
        if (currentCount >= config.getMaxRequests()) {
            System.out.println("LIMIT EXCEEDED for " + clientId + "!");
            throw new RateLimitExceededException("Rate limit exceeded for client: " + clientId);
        }

        // Increment count
        requestCounts.put(clientId, currentCount + 1);

        // Finally, if we passed the limit we call the external service
        externalClient.callExternalApi(payload);
        System.out.println("Processed Successfully.\n");
    }
}
