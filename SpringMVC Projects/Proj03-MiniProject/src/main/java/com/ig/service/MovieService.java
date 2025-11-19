package com.ig.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.entity.Movie;
import com.ig.model.VOMovie;
import com.ig.repo.IMovieRepo;

@Service
public class MovieService 
{
	@Autowired
	private IMovieRepo repo;
	
	public VOMovie findById(Integer id)
	{
		Movie entity =  repo.findById(id).orElseThrow(
				()->new IllegalArgumentException("Invalid id: "+id)
				);
		VOMovie vo = new VOMovie();
		BeanUtils.copyProperties(entity, vo);
		return vo;
	}
	
	public Movie findEntityById(Integer id)
	{
		Movie entity =  repo.findById(id).orElseThrow(
				()->new IllegalArgumentException("Invalid id: "+id)
				);
		return entity;
	}
	
	public List<VOMovie> findAll()
	{
		Iterable<Movie> movies = repo.findAll();
		List<VOMovie> voMovies = new ArrayList<VOMovie>();
		movies.forEach(
				t->{
					VOMovie vo = new VOMovie();
					BeanUtils.copyProperties(t, vo);
					voMovies.add(vo);
					}
				);
		
		return voMovies;
	}
	
	public String save(VOMovie vo)
	{
		Movie entity = new Movie();
		BeanUtils.copyProperties(vo, entity);
		Movie saved = repo.save(entity);
		return "Movie ["+saved.getId()+"] saved in database.";
	}
	
	public String update(VOMovie vo)
	{
	 	Movie entity =  findEntityById(vo.getId());
		BeanUtils.copyProperties(vo, entity);
		Movie saved = repo.save(entity);
		return "Movie ["+saved.getId()+"] updated in database.";
	}
	
	public String delete(Integer id)
	{
		Movie entity =  findEntityById(id);
		repo.deleteById(id);
		return "Movie ["+id+"] deleted from database.";
	}
}
