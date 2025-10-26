package com.ig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.entity.DateTimeEntity;
import com.ig.repo.IDateTimeRepo;

@Service
public class DateTimeService 
{
	@Autowired
	private IDateTimeRepo repo;
	
	public String save(DateTimeEntity entity)
	{
		DateTimeEntity  saved = repo.save(entity);
		return "Saved Entity(DateTimeEntity) with Id["+saved.getId()+"]";
	}
	
	public String CalucalteAgeById(Long user_id)
	{
		Double  age = repo.CalucalteAgeById(user_id);
		
		return "USER_ID ["+user_id+"], AGE ["+age+"]";
	}
	public Iterable<DateTimeEntity> findAll()
	{
		return repo.findAll();
	}
	
}
