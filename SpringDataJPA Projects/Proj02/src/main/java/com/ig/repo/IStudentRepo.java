package com.ig.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ig.entity.Student;

public interface IStudentRepo extends JpaRepository<Student, Integer>
//,PagingAndSortingRepository<Movie, Integer>,CrudRepository<Movie, Integer>
{
	
}
