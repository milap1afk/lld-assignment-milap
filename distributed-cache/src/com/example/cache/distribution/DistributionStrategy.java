package com.example.cache.distribution;

import com.example.cache.CacheNode;
import java.util.List;

public interface DistributionStrategy {
    CacheNode getNode(List<CacheNode> nodes, String key);
}
