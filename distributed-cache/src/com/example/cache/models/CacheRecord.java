package com.example.cache.models;

public class CacheRecord {
    private String key;
    private String value;
    private long lastAccessedTime;

    public CacheRecord(String key, String value) {
        this.key = key;
        this.value = value;
        this.lastAccessedTime = System.currentTimeMillis();
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public long getLastAccessedTime() {
        return lastAccessedTime;
    }

    public void updateAccessTime() {
        this.lastAccessedTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "CacheRecord{" + "key='" + key + '\'' + ", value='" + value + '\'' + '}';
    }
}
