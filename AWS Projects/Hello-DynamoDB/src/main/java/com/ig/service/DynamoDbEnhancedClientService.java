package com.ig.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.entity.Movie;
import com.ig.repository.MovieRepo;

@Service
public class DynamoDbEnhancedClientService 
{
	@Autowired
	private MovieRepo repo;
	
	public List<Movie> getAll()
	{
		return repo.getAll();
	}
	
	public String save(Movie movie)
	{
		Movie item = repo.save(movie);
		return "Movie ["+item.toString()+"] saved successfully";
	}
	
	public String getByIdAsString(Movie movie)
	{
		Movie item = getById(movie);
		return "Movie ["+item.toString()+"] fetched successfully";
	}
	
	public Movie getById(Movie movie)
	{
		Movie item = repo.getById(movie);
		return item;
	}
	
	public String update(Movie movie)
	{
		Movie item = repo.update(movie);
		return "Movie ["+item.toString()+"] updated successfully";
	}
}
