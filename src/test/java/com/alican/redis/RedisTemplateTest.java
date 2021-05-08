package com.alican.redis;

import com.alican.redis.service.RedisTemplateService;
import com.alican.redis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    private RedisTemplateService redisTemplateService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testList() {
        redisTemplateService.listSample();
    }

    @Test
    public void testSet() {
        redisTemplateService.setSample();
    }

    @Test
    public void testHash() {
        redisTemplateService.hashSample();
    }

}
