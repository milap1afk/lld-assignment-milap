package com.example.ratelimiter.resources;

public interface ExternalResourceClient {
    String callExternalApi(String payload);
}
