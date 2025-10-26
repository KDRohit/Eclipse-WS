package com.ig.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import com.ig.entity.DateTimeEntity;
import com.ig.entity.Movie;
import com.ig.service.DateTimeService;

@Controller
@Profile({"datetime-in-mysql","datetime-in-oracle"})
public class DateTimeController implements AppController {
	
	@Autowired
	private DateTimeService service;
	
	@Override
	public void showMenu(boolean isFirst) 
	{
		if(isFirst)
		{
			System.out.println("Welcome in the app:-\n ------DateTime(App)-------------");
		}	
		System.out.println("Menu(Items):-");
		System.out.println("1)- Save DateTimeEntity                                                                     [INSERTION(CRUD)]");
		System.out.println("2)- Calculate Age                                                                                 [INSERTION(CRUD)]");
		System.out.println("0)- Exit App                                                                                          [EXIT]");
		getAndProcessInput();
	}

	@Override
	public void getAndProcessInput()
	{
		int ch = getInput("Enter option:-", 0);
		DateTimeEntity dtEntity =null;
		Iterable<Movie> dtEntities = null;
		switch (ch) {
			case 1:
			dtEntity = getDateTimeEntity();
			String msg =  service.save(dtEntity);
			System.out.println(msg);
			showMenu(false);
			break;
			
			case 2:
				ch = getInput("Enter User [Id] :-", 0);
				System.out.println(service.CalucalteAgeById(Long.valueOf(ch)));
				showMenu(false);
				break;
		}
	}
	
	private DateTimeEntity getDateTimeEntity()
	{
		int year = getInput("Enter [BIRTH]  year", 0);
		int month = getInput("Enter [BIRTH] month", 0);
		int day = getInput("Enter [BIRTH] day", 0);
		
		LocalDate date = LocalDate.of(year, month, month);
		
		int hrs = getInput("Enter [BIRTH]  hrs", 0);
		int min = getInput("Enter [BIRTH] minute", 0);
		
		LocalTime time = LocalTime.of(hrs, min);
		
		LocalDateTime local_date_time = LocalDateTime.of(date, time);
		return new DateTimeEntity(local_date_time,time,date);
	}
}
