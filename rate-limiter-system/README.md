Design a Pluggable Rate Limiting System (Refactoring)
=====================================================

## Context
You are building a backend system that serves client API requests. The system frequently makes internal service calls. Only under certain business conditions, it reaches out to an external resource which is a paid service billed by usage.

We need a rate limiting system specifically for the external resource call (so not every incoming API call impacts the quota). 

## Narrative (Current Code)
The current developer tried to achieve this but wrote a highly coupled `MonolithicRateLimiterService`.
- **Tight Coupling:** The logic to check for Fixed Window Counter is hardcoded alongside the business logic condition checking.
- **Single Thread Failure:** It uses simple unbounded internal maps and isn't thread-safe for concurrency.
- **No Extensibility:** If the company decides to switch to Sliding Window or Token Bucket tomorrow, they will have to rewrite the core flow.

## Your Task
Use SOLID principles to design a rate limiting system that decides whether a particular external call is allowed or denied based on the client, tenant, or API key.

### Requirements:
1. **Pluggable Algorithms:**
   - Define a `RateLimitingAlgorithm` interface. 
   - Implement `FixedWindowCounter` and `SlidingWindowCounter`.
   - Show how a caller can switch between algorithms without modifying business logic.

2. **Decoupling Business Logic:**
   - The rate limiter must be a distinct module interacting cleanly with the external resource client. 

3. **Concurrency:**
   - Ensure your designs for `FixedWindowCounter` and `SlidingWindowCounter` are thread-safe.

4. **Questions to Answer (Add in a text file or in comments):**
   - Explain your key design decisions regarding thread-safety.
   - Discuss trade-offs between Fixed Window and Sliding Window Counter.

## Acceptance Criteria
- External logic is fully decoupled from rate limiter algorithm calculation.
- Stubs are replaced with actual algorithms.
- `App.java` handles testing simulated burst requests and correctly rejects rate-limited calls gracefully.

## Build & Run
```bash
cd rate-limiter-system/src
javac com/example/ratelimiter/**/*.java com/example/ratelimiter/*.java
java com.example.ratelimiter.App
```
