Design a Distributed Cache (Refactoring)
========================================

## Context
You are asked to design and implement a distributed cache system that supports `get(key)` and `put(key, value)`. 

## Narrative (Current Code)
A developer attempted to create a distributed cache. However, the current code is a massive `MonolithicDistributedCache` class. It manages everything: keeping track of nodes, calculating hashing routines, managing the LRU eviction policy manually inside tight loops, and fetching from the database. 

Problems in the current design:
- **Tight Coupling:** The `MonolithicDistributedCache` calculates data distribution directly (modulo-based). Changing to consistent hashing requires editing core code.
- **Hardcoded Eviction:** A makeshift LRU logic is explicitly coded right where `put` happens. If we want MRU or LFU, we have to rewrite part of the core logic.
- **Single Responsibility Violation:** One class does distribution, connection to the database, tracking cache misses, and internal cache state management all simultaneously.

## Your Task
Use SOLID principles to split responsibilities and create an extendable Object-Oriented design.

1. **Pluggable Distribution Strategy:**
   - Extract the distribution logic.
   - The system should support an interface (like `DistributionStrategy`) to decide which cache node will store a given key.
   - Implement `ModuloDistributionStrategy` as default. Design it so `ConsistentHashingStrategy` could be plugged in easily later.

2. **Pluggable Eviction Policy:**
   - Instead of hardcoding LRU inside the cache logic, extract it.
   - Define an `EvictionPolicy` interface.
   - Implement `LRUEvictionPolicy` so that the cache node delegate its capacity management cleanly. Expect to drop in LFU or MRU easily.

3. **Cache Nodes:**
   - Make the `CacheNode` intelligent enough to handle its own eviction policy instead of relying on the supervisor loop to do it.

## Acceptance Criteria
- Code must be decoupled: Distribution and Eviction logic should be totally separated from the core cache engine.
- Provide implementations for Interfaces (`DistributionStrategy`, `EvictionPolicy`).
- If a cache miss occurs during `get()`, fetch from the database, cache it in the right node, and return it.
- Class structure must reflect standard design patterns (Strategy, Dependency Injection).
- Console output should verify node selection and cache misses/hits.

## Build & Run
```bash
cd distributed-cache/src
javac com/example/cache/**/*.java com/example/cache/*.java
java com.example.cache.App
```
