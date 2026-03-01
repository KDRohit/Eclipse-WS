package com.ig.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuizRepo extends JpaRepository<QuizEntity, Integer> 
{
	
}
