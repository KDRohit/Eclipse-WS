package com.ig.controllers;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ig.entity.Movie;
import com.ig.service.DynamoDbClientService;
import com.ig.service.DynamoDbEnhancedClientService;

@RestController
@RequestMapping("/movies")
public class MovieController
{
	@Autowired
	public DynamoDbEnhancedClientService service;
	
	@GetMapping("/all")
	public  List<Movie> allMovie()
	{
		return service.getAll();
	}
	
	@GetMapping("/save/{name}")
	public String saveMovie(@PathVariable("name") String name)
	{
		Movie item = new Movie(UUID.randomUUID().toString(), name);
		return service.save(item);
	}
	
	@GetMapping("/get/{id}")
	public String getMovie(@PathVariable("id") String id)
	{
		Movie partialItem = new Movie();
		partialItem.setId(id);
		return service.getByIdAsString(partialItem);
	}
	
	@GetMapping("/update/{id}/{name}")
	public String updateMovie(@PathVariable("id") String id, @PathVariable("name") String name)
	{
		Movie partialItem = new Movie();
		partialItem.setId(id);
		
		Movie fullItem = service.getById(partialItem);
		fullItem.setName(name);
		return service.update(fullItem);
	}
	
}
