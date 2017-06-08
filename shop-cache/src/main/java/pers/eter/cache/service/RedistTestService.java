package pers.eter.cache.service;

import org.springframework.stereotype.Service;
import pers.eter.cache.config.RedisClient;

import javax.annotation.Resource;

/**
 * Created by Eter on 17-6-6.
 */
@Service
public class RedistTestService {
    @Resource
    private RedisClient redisClient;

    public void set(String key, String value) {
        /*before*/
        redisClient.sete(key, value);
        /*agter*/
    }

    public String get(String key) {
        return redisClient.get(key);
    }
}
