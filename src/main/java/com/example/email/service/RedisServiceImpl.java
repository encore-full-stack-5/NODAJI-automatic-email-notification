package com.example.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService{
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(String key, String value) {
        redisTemplate.opsForValue().set(key, value, 1, TimeUnit.MINUTES);

    }

    public Object get(String key) {
        Object value = redisTemplate.opsForValue().get(key);
        if (value == null) {
            return ("Value not found or expired for key: " + key);
        } else {
            return ("Retrieved value: " + value + " for key: " + key);
        }
    }


}
