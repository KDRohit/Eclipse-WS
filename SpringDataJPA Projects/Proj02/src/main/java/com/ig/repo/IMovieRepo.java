package com.ig.repo;

import org.springframework.data.repository.CrudRepository;
import com.ig.entity.Movie;

public interface IMovieRepo extends CrudRepository<Movie, Integer>
{
	
}
