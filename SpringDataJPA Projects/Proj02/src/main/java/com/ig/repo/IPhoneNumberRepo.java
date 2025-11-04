package com.ig.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ig.entity.PhoneNumber;
import com.ig.entity.Student;

public interface IPhoneNumberRepo extends JpaRepository<PhoneNumber, Integer>
//,PagingAndSortingRepository<Movie, Integer>,CrudRepository<Movie, Integer>
{
	
}
