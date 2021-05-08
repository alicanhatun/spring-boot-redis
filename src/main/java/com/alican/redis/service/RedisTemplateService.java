package com.alican.redis.service;

import com.alican.redis.entity.RedisCacheObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisTemplateService {

    @Autowired
    private RedisTemplate redisTemplate;

    public void listSample() {
        RedisCacheObject samet = new RedisCacheObject(555L, "Samet");
        RedisCacheObject sarper = new RedisCacheObject(666L, "Sarper");
        redisTemplate.opsForList().leftPush("LIST::" + samet.getId(), samet);
        redisTemplate.opsForList().leftPush("LIST::" + samet.getId(), samet);
        redisTemplate.opsForList().leftPush("LIST::" + samet.getId(), samet);
        redisTemplate.opsForList().leftPush("LIST::" + samet.getId(), sarper);
        redisTemplate.opsForList().leftPush("LIST::" + sarper.getId(), sarper);
        redisTemplate.opsForList().size(samet.getId());
    }

    public void setSample() {
        RedisCacheObject yusuf = new RedisCacheObject(333L, "Yusuf");
        RedisCacheObject ozden = new RedisCacheObject(444L, "Özden");
        redisTemplate.opsForSet().add("SET::" + yusuf.getId(), yusuf);
        redisTemplate.opsForSet().add("SET::" + yusuf.getId(), yusuf);
        redisTemplate.opsForSet().add("SET::" + yusuf.getId(), yusuf);
        redisTemplate.opsForSet().add("SET::" + yusuf.getId(), ozden);
        redisTemplate.opsForSet().add("SET::" + ozden.getId(), ozden);
    }

    public void hashSample() {
        RedisCacheObject alican = new RedisCacheObject(111L, "Alican");
        RedisCacheObject gokce = new RedisCacheObject(222L, "Gökçe");
        redisTemplate.opsForHash().put("HASH::", alican.getId(), alican);
        redisTemplate.opsForHash().put("HASH::", alican.getId(), alican);
        redisTemplate.opsForHash().put("HASH::", alican.getId(), alican);
        redisTemplate.opsForHash().put("HASH::", alican.getId(), gokce);
        redisTemplate.opsForHash().put("HASH::", gokce.getId(), gokce);
    }

}
