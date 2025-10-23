package com.ig.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.ig.entity.Movie;

public interface IMovieRepo extends JpaRepository<Movie, Integer>
//,PagingAndSortingRepository<Movie, Integer>,CrudRepository<Movie, Integer>
{
	public Movie getByMovieName(String movieName);
	public List<Movie> getByMovieActor(String movieName);
	public List<Movie> getByMovieNameStartingWith(String str);
	public List<Movie> getByMovieNameEndingWith(String str);
	
	
	@Query("from Movie where movieActor = ?1 and movieActress=?2")
	public List<Movie> fetchMoviesByActorAndActress(String actor,String actress);
	
	@Query("from Movie where movieActor =:actor and movieActress=:actress")
	public List<Movie> fetchMoviesByActorAndActressV2(String actor,String actress);
	
	@Query("from Movie where movieActor =:param1 and movieActress=:param2")
	public List<Movie> fetchMoviesByActorAndActressV3(@Param("param1") String actor, @Param("param2") String actress);
	
	@Query("select movieReleaseDate from Movie where movieName=:movieName")
	public LocalDate fetchReleaseDateByMovieName(String movieName);
	
	@Query("select movieActor,movieActress from Movie where movieName=:movieName")
	public Optional<Object> fetchActorAndActressByMovieName(String movieName);
	
}
