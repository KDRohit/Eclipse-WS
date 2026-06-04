package com.ig.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ig.entity.EntityMovie;
import com.ig.repo.IEntityMovieRepo;
import com.ig.response.Response;

@Service
public class MovieService
{
	@Autowired
	private IEntityMovieRepo repo;
	
	@CacheEvict(value = "movies", allEntries = true)
	public Response<EntityMovie> saveMovie(EntityMovie m)
	{
		EntityMovie saved = repo.save(m);
		return new Response<EntityMovie>(201,"movie saved successfully!",saved);
	}
	
	@Cacheable(value = "movies")
	public Response<List<EntityMovie>> getAllMovies()
	{
		System.out.println("fetching data from db");
		return new Response<List<EntityMovie>>(201,"movie is retrived from db!",repo.findAll());
	}
}
