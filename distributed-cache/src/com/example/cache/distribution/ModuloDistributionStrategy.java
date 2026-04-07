package com.example.cache.distribution;

import com.example.cache.CacheNode;
import java.util.List;

public class ModuloDistributionStrategy implements DistributionStrategy {
    @Override
    public CacheNode getNode(List<CacheNode> nodes, String key) {
        // TODO: Move the routing logic from MonolithicDistributedCache here.
        return null;
    }
}
