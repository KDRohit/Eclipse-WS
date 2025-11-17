package com.ig.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ig.entity.Movie;

public interface IMovieRepo extends JpaRepository<Integer, Movie> 
{

}
