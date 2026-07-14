package com.ig.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ig.item.Item;
import com.ig.item.Jeans;

import jakarta.annotation.PostConstruct;

@Service
public class InventoryService 
{
	List<Item> items;
	
	@PostConstruct
    public void init() 
	{
		items = new ArrayList<>();
		items.add(new Jeans(UUID.randomUUID().toString(),"levis",1500));
		items.add(new Jeans(UUID.randomUUID().toString(),"tokyo",2500));
		items.add(new Jeans(UUID.randomUUID().toString(),"burmunda",3500));
		items.add(new Jeans(UUID.randomUUID().toString(),"presly",500));
    }
	
	public List<Item> getAll()
	{
		return items;
	}
	
	public String onBuySuccess(String id)
	{
		items.stream().
	}
	
}
