package com.example.ratelimiter.resources;

public class MockBillingClient implements ExternalResourceClient {
    @Override
    public String callExternalApi(String payload) {
        // Simulates the external Paid API
        System.out.println("[PAID API] External API successfully hit with payload: " + payload);
        return "SUCCESS";
    }
}
