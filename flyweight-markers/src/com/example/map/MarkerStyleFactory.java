package com.example.map;

import java.util.HashMap;
import java.util.Map;

public class MarkerStyleFactory {
    private final Map<String, MarkerStyle> cache = new HashMap<>();

    public MarkerStyle getStyle(String shape, String color, int size, boolean filled) {
        String key = shape + "|" + color + "|" + size + "|" + (filled ? "F" : "NF");

        if (!cache.containsKey(key)) {
            MarkerStyle style = new MarkerStyle(shape, color, size, filled);
            cache.put(key, style);
        }

        return cache.get(key);
    }

    public int getUniqueStyleCount() {
        return cache.size();
    }
}
