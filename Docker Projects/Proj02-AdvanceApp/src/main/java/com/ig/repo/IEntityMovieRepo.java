package com.ig.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ig.entity.EntityMovie;

public interface IEntityMovieRepo extends JpaRepository<EntityMovie, Long> 
{
	
}
