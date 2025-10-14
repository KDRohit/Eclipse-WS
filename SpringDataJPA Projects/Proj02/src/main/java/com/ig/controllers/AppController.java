package com.ig.controllers;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ig.entity.Movie;
import com.ig.service.MovieService;

@Component("appController")
public class AppController 
{
	@Autowired
	private MovieService movieService;
	private Scanner sc = new Scanner(System.in);
	
	public void showMenu(boolean isFirst)
	{
		if(isFirst)
		{
			System.out.println("Welcome in the app:-\n ------MovieFlix-------------");
		}
		System.out.println("Menu(Items):-");
		System.out.println("1)- Save Movie");
		System.out.println("2)- SelectAll Movie");
		System.out.println("3)- SelectById Movie");
		System.out.println("4)- SelectById Movie (best)");
		System.out.println("5)- SelectAllByIds Movie");
		System.out.println("6)- Total Movie");
		System.out.println("7)- Exist Movie By Id");
		System.out.println("8)- Save All Movie");
		System.out.println("0)- Exit App");
		getAndProcessInput();
	}
	
	private void getAndProcessInput()
	{
		int ch = getInput("Enter option:-", 0);
		Movie mov =null;
		Iterable<Movie> movies = null;
		boolean result=false;
		switch (ch) {
			case 1:
			mov = getMovie();
			mov =  movieService.saveMovie(mov);
			System.out.println("Saved (Movie) :-"+mov);
			showMenu(false);
			break;
			
			case 2:
				movies =  movieService.findAllMovie();
				movies.forEach(System.out::println);
				showMenu(false);
				break;
				
			case 3:
				ch = getInput("Enter movie id:-", 0);
				System.out.println(movieService.findByIdMovie(ch));
				showMenu(false);
				break;
				
			case 4:
				ch = getInput("Enter movie id:-", 0);
				try 
				{
					System.out.println("find movie:-"+movieService.findByIdMovieVersion2(ch));
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
				showMenu(false);
				break;
				
			case 5:
				List<Integer> al = new ArrayList<>();
				while(true)
				{
					ch = getInput("Enter movie id (-1 to exit):-", 0);
					if(ch<0)
					break;
					al.add(ch);
				}
				movies = movieService.findAllByIdMovie(al);
				movies.forEach(System.out::println);
				showMenu(false);
				break;
				
			case 6:
				System.out.println("Total Movies: "+movieService.getTotalMovieInDB());
				showMenu(false);
				break;
				
			case 7:
				ch = getInput("Enter movie id:-", 0);
				result = movieService.existsByIdMovie(ch);
				System.out.println(result?"Movie Found":"Movie not found!!!");
				showMenu(false);
				break;
			case 8:
				List<Movie> list = new ArrayList<Movie>();
				do 
				{
					Movie temp = getMovie();
					list.add(temp);	
				}
				while(getInput("exit(-1) else (any number)", 0)>-1);
				
				movies =  movieService.saveAllMovie(list);
				System.out.println("Saved Movies below:-");
				movies.forEach(System.out::println);
				showMenu(false);
				break;
			default:
			System.out.println("Invalid Inputs\nBye, See you again!!!");
		}
	}
	
	private Movie getMovie()
	{
		String movName = getInput("Enter movie name:-", "");
		String actor = getInput("Enter actor name:-", "");
		String actress = getInput("Enter actress name:-", "");
		int year = getInput("Enter release year", 0);
		int month = getInput("Enter release month", 0);
		int day = getInput("Enter release day", 0);
		LocalDate date = LocalDate.of(year, month, month);
		return new Movie(movName,actor, actress,date);
	}
	
	private <T> T getInput(String msg,T t)
	{
		System.out.println(msg);
		if(t instanceof String)
		{
			return (T)sc.nextLine();
		}
		if(t instanceof Integer)
		{
			Integer inp = Integer.parseInt(sc.nextLine());
			 return (T)inp;		 
		}
		return null;
	}
	
}
