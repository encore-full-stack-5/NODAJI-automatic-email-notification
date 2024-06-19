package com.example.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService{
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Override
    public void save(String key, String value) {

    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
