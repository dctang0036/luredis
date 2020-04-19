package com.luredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LuredisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void RedisTemplate() {
        System.out.println(redisTemplate);
        String str1 = (String)redisTemplate.opsForValue().get("db-type");
        if (str1 != null) {
            System.out.println(str1);
        } else {
            redisTemplate.opsForValue().set("db-type", "redis");
            System.out.println(redisTemplate.opsForValue().get("db-type"));
        }
    }

}
