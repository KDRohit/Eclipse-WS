package com.ig.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ig.entity.Movie;
import com.ig.exceptions.CustomException;
import com.ig.repo.IMovieRepo;

@Service("movieService")
public class MovieService
{
	@Autowired
	private IMovieRepo repo;
	
	public Movie saveMovie_CrudRepo(Movie movie)
	{
		Movie saved =  repo.save(movie);
		return saved;
	}
	
	public Iterable<Movie> findAllMovie_CrudRepo()
	{
		Iterable<Movie> it = repo.findAll();
		return it;
	}
	
	public String findByIdMovie_CrudRepo(Integer id)
	{
		Optional<Movie> op = repo.findById(id);
		if(op.isPresent())
			return op.get().toString();
		return "No Movie Found";
	}
	
	public Movie findByIdMovieVersion2_CrudRepo(Integer id) throws CustomException
	{
		return repo.findById(id).orElseThrow(()->new CustomException("Invalid Id:-"+id));
	}
	
	public Iterable<Movie> findAllByIdMovie_CrudRepo(Iterable<Integer> it)
	{
		Iterable<Movie> al = repo.findAllById(it);
		return al;
	}
	
	public long getTotalMovieInDB_CrudRepo()
	{
		return repo.count();
	}
	
	public boolean existsByIdMovie_CrudRepo(Integer id)
	{
		return repo.existsById(id);
	}
	
	public Iterable<Movie> saveAllMovie_CrudRepo(Iterable<Movie> movies)
	{
		return repo.saveAll(movies);
	}
	
	// partial updation[recommended] 
	// [fully insertion is not recommended as generator's generate issue comes in picture.]
	public String updateMovieName_CrudRepo(Integer id, String newName) throws CustomException
	{
		Movie movie =  repo.findById(id).orElseThrow(()->new CustomException("Movie not found"));
		String oldName=movie.getMovieName();
		movie.setMovieName(newName);
		repo.save(movie);
		return "movie["+oldName+"] changed to ["+movie.getMovieName()+"]";
	}
	
	public String deleteByIdMovie_CrudRepo(Integer id)
	{
		boolean isExistsById =  repo.existsById(id);
		if(isExistsById)
		{
			repo.deleteById(id);
			return "movie with [id:-"+id+"] deleted";
		}
		return "movie with [id:-"+id+"] not found!";
	}
	
	// delete movies by ids.
	public String deleteAllByIdMovie_CrudRepo(Iterable<Integer> ids)
	{
		Iterable<Movie> allMoviesById =  repo.findAllById(ids);
		long count = StreamSupport.stream(allMoviesById.spliterator(), false).count();
		if(count>0)
		{
			repo.deleteAllById(ids);
			return "movies[count="+count+"] deleted";
		}
		return "no movies found";
	}
	
	// delete movies by ids.
		public String deleteAll_CrudRepo()
		{
			Iterable<Movie> allMovies =  repo.findAll();
			long count = StreamSupport.stream(allMovies.spliterator(), false).count();
			if(count>0)
			{
				repo.deleteAll();
				return "movies[count="+count+"] deleted"; 
			}
			return "no movies found";
		}
		
		// ----------paging and sorting repository methods--------------
		//------------------------------------------------------------------
		public Iterable<Movie> findAllMovie_PAS(boolean ascOrder,String... args)
		{
			Sort sort = Sort.by(ascOrder?Direction.ASC:Direction.DESC, args);
			Iterable<Movie> it = repo.findAll(sort);
			return it;
		}
		
		public Page<Movie> getPage_PAS(int pageno,int pagesize)
		{
			Pageable pageable = PageRequest.of(pageno, pagesize);
			Page<Movie> page = repo.findAll(pageable);
			return page;
		}
		
		public Page<Movie> sortAndGetPage_PAS(int pageno,int pagesize,boolean asc,String... props)
		{
			Sort sort = Sort.by(asc?Sort.Direction.ASC:Sort.Direction.DESC,props);
			Pageable pageable = PageRequest.of(pageno, pagesize,sort);
			Page<Movie> page = repo.findAll(pageable);
			return page;
		}
		
		// ----------JPA repository methods--------------
		//------------------------------------------------------------------
		
		public Movie findOneMovie_JPA(Movie dummyMovie)
		{
			Example<Movie> example =  Example.of(dummyMovie);
			return repo.findOne(example).orElseThrow(()->new IllegalArgumentException("invalid data"));	
		}
		
		public List<Movie> findAllMovie_JPA(Movie dummyMovie)
		{
			Example<Movie> example =  Example.of(dummyMovie);
			return repo.findAll(example);
		}
		
		public String deleteAllByIdInBatchMovie_JPA(Iterable<Integer> ids)
		{
			Iterable<Movie> movies = repo.findAllById(ids);
			long count = StreamSupport.stream(movies.spliterator(), false).count();
			if(count>0)
			{
				repo.deleteAllByIdInBatch(ids);
				return "Movies ["+count+"] Deleted.";
			}
			return "No Movie/s Found";
		}
		
		
		// custom methods.....................
		
		public Movie getMovieByMovieName_JPA(String name)
		{
			return repo.getByMovieName(name);
		}
		
		public List<Movie> getMoviesByActorName_JPA(String name)
		{
			return repo.getByMovieActor(name);
		}
		
		public List<Movie> getMovieByMovieNameStartingWith_JPA(String name)
		{
			return repo.getByMovieNameStartingWith(name);
		}
		
		public List<Movie> getMovieByMovieNameEndingWith_JPA(String name)
		{
			return repo.getByMovieNameEndingWith(name);
		}
		
		public List<Movie> fetchMoviesByActorAndAcress(String actor,String actress)
		{
			return repo.fetchMoviesByActorAndActress(actor,actress);
		}
		
		public List<Movie> fetchMoviesByActorV2(String actor,String actress)
		{
			return repo.fetchMoviesByActorAndActressV2(actor,actress);
		}
		
		public List<Movie> fetchMoviesByActorV3(String actor,String actress)
		{
			return repo.fetchMoviesByActorAndActressV3(actor,actress);
		}
		
		public LocalDate fetchReleaseDateByMovieName(String movieName)
		{
			return repo.fetchReleaseDateByMovieName(movieName);
		}
		
		public String fetchActorAndActressByMovieName(String movieName)
		{
			Optional<Object> opt =  repo.fetchActorAndActressByMovieName(movieName);
			if(opt.isPresent())
			{
				Object[] data =(Object[])opt.get();
				return "[Actor="+data[0].toString()+", Actress="+data[1].toString()+"]";
			}
			else
			{
				return "No Data found";
			}
		}
		
}
