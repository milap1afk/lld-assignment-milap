package com.example.ratelimiter;

import com.example.ratelimiter.config.RateLimitConfig;
import com.example.ratelimiter.exceptions.RateLimitExceededException;
import com.example.ratelimiter.resources.ExternalResourceClient;
import com.example.ratelimiter.resources.MockBillingClient;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Rate Limiter Simulator ===");

        ExternalResourceClient billingClient = new MockBillingClient();
        
        // Config: 2 requests allowed per 5000ms window
        RateLimitConfig config = new RateLimitConfig(2, 5000);
        
        MonolithicRateLimiterService service = new MonolithicRateLimiterService(billingClient, config);

        String t1 = "Tenant-1";

        System.out.println("--- Scenario 1: Internal API Call Only ---");
        // Business logic routes it WITHOUT needing external resources, should not touch quota.
        service.processClientRequest(t1, false, "Internal Auth payload");

        System.out.println("--- Scenario 2: Paid External Call 1 ---");
        service.processClientRequest(t1, true, "Paid Payload A");

        System.out.println("--- Scenario 3: Paid External Call 2 ---");
        service.processClientRequest(t1, true, "Paid Payload B");

        System.out.println("--- Scenario 4: Paid External Call 3 (Should Fail) ---");
        try {
            service.processClientRequest(t1, true, "Paid Payload C");
        } catch (RateLimitExceededException ex) {
            System.out.println("Caught Expected Exception: " + ex.getMessage());
        }

        System.out.println("\n--- Simulator Finished ---");
    }
}
