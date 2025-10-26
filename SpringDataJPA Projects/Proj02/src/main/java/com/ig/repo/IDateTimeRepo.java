package com.ig.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ig.entity.DateTimeEntity;

public interface IDateTimeRepo extends JpaRepository<DateTimeEntity, Long> 
{
	@Query(value =  "select ROUND(TIMESTAMPDIFF(DAY,date_of_birth,CURDATE())/365.25,2) from jpa_date_time where user_id = :user_id",nativeQuery = true)
	public Double CalucalteAgeById(Long user_id);
}
