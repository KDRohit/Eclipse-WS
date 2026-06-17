package com.ig.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ig.entity.Movie;
import com.ig.service.DynamoDbService;

@RestController
@RequestMapping("/movies")
public class MovieController
{
	@Autowired
	public DynamoDbService service;
	
	@GetMapping("/save/{name}")
	public Movie saveMovie(@PathVariable String name)
	{
		return service.saveMovie(name);
	}
}
