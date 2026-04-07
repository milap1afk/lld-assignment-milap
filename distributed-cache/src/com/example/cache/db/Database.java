package com.example.cache.db;

public interface Database {
    String readFromDb(String key);
    void writeToDb(String key, String value);
}
