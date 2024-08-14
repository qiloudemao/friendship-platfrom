package com.wt.friendship;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest {
    @Resource
    private RedisTemplate redisTemplate;

//    @Test
//    void  test(){
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("wt","wt");
//    }
}
