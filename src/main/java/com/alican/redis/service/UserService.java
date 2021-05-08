package com.alican.redis.service;

import com.alican.redis.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final String KEY = "user";

    @Cacheable(value = KEY, key = "#id", unless = "#result == null")
    public User findUserById(int id) throws InterruptedException {
        System.out.println("Cacheable is working");
        Thread.sleep(5000L);
        return new User(id, "ali", "can", 30);
    }

    @CacheEvict(value = KEY, key = "#id")
    public void deleteUser(int id) {
        System.out.println("CacheEvict is working for " + id);
    }

    @CachePut(value = KEY, key = "#user.id")
    public User updateUser(User user) throws InterruptedException {
        System.out.println("CachePut is working");
        Thread.sleep(5000L);
        return new User(user.getId(), "gök", "che", 20);
    }
}
