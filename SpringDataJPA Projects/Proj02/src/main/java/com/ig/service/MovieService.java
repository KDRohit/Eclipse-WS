package com.ig.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ig.entity.Movie;
import com.ig.exceptions.MovieException;
import com.ig.repo.IMovieRepo;

@Component("movieService")
public class MovieService
{
	@Autowired
	private IMovieRepo repo;
	
	public Movie saveMovie(Movie movie)
	{
		Movie saved =  repo.save(movie);
		return saved;
	}
	
	public Iterable<Movie> findAllMovie()
	{
		Iterable<Movie> it = repo.findAll();
		return it;
	}
	
	public String findByIdMovie(Integer id)
	{
		Optional<Movie> op = repo.findById(id);
		if(op.isPresent())
			return op.get().toString();
		return "No Movie Found";
	}
	
	public Movie findByIdMovieVersion2(Integer id) throws MovieException
	{
		return repo.findById(id).orElseThrow(()->new MovieException("Invalid Id:-"+id));
	}
	
	public Iterable<Movie> findAllByIdMovie(Iterable<Integer> it)
	{
		Iterable<Movie> al = repo.findAllById(it);
		return al;
	}
	
	public long getTotalMovieInDB()
	{
		return repo.count();
	}
	
	public boolean existsByIdMovie(Integer id)
	{
		return repo.existsById(id);
	}
	
	public Iterable<Movie> saveAllMovie(Iterable<Movie> movies)
	{
		return repo.saveAll(movies);
	}
	
	public void updateMovie(Movie movie)
	{
		
	}
}
