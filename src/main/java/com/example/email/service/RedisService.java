package com.example.email.service;

public interface RedisService {
    void save(String key, String value);
    Object get(String key);
}
