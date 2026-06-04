package com.ig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ig.entity.EntityMovie;
import com.ig.response.Response;
import com.ig.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController 
{
	@Autowired
	public MovieService movieService;
	
	@GetMapping("/getall")
	public Response<List<EntityMovie>> getAllMovies()
	{
		return movieService.getAllMovies();
	}
	
	@GetMapping("/save/{name}/{actor}/{actress}")
	public Response<EntityMovie> saveMovie(@PathVariable String name, @PathVariable String actor, @PathVariable String actress)
	{
		EntityMovie movie = new EntityMovie(name, actor, actress);
		return movieService.saveMovie(movie);
	}
}
