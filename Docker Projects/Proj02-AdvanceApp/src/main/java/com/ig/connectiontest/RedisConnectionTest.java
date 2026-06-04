package com.ig.connectiontest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisConnectionTest implements CommandLineRunner 
{
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 redisTemplate.opsForValue().set("test-key", "hello");
	     String value = redisTemplate.opsForValue().get("test-key");
         System.out.println("Redis Value: " + value);
	}

}
