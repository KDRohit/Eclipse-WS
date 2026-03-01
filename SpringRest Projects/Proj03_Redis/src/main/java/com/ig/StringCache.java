package com.ig;

import java.util.Random;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class StringCache
{
	@Cacheable("gfn")
	public String getFullName()
	{
		System.out.println("--------not caching-------");
		return "rohit kumar dubey";
	}
	
	@CachePut("gfn")
	public String updateFullName()
	{
		System.out.println("--------updating caching-------");
		return "amit kumar dubey ["+new Random().nextInt(1000)+"]";
	}
	
	@CacheEvict("gfn")
	public void removeFullName()
	{
		System.out.println("--------removing caching-------");
	}
}
