package com.ig.controllers;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import com.ig.entity.Movie;
import com.ig.service.MovieService;

@Controller("movieAppController")
@Profile({"movie-in-mysql","movie-in-oracle"})
public class MovieAppController implements AppController
{
	@Autowired
	private MovieService movieService;
	
	public void showMenu(boolean isFirst)
	{
		if(isFirst)
		{
			System.out.println("Welcome in the app:-\n ------MovieFlix-------------");
		}
		System.out.println("Menu(Items):-");
		System.out.println("1)- Save Movie                                                                           [INSERTION(CRUD)]");
		System.out.println("2)- SelectAll Movie                                                                    [SELECTION-ALL(CRUD)");
		System.out.println("3)- SelectById Movie                                                                 [SELECTION-BY-ID(CRUD)]");
		System.out.println("4)- SelectById Movie (best)                                                      [SELECTION-BY-ID(CRUD)]");
		System.out.println("5)- SelectAllByIds Movie                                                           [SELECTION-ALL-BY-ID(CRUD)]");
		System.out.println("6)- Total Movie                                                                          [COUNT(CRUD)]");
		System.out.println("7)- Exist Movie By Id                                                                 [EXIST OR NOT BY ID(CRUD)]");
		System.out.println("8)- Save All Movie                                                                     [INSERTION MULTIPLE(CRUD)]");
		System.out.println("9)- Update Movie Name                                                          [UPDATION(CRUD)]"); 
		System.out.println("10)- Delete Movie By Id                                                            [DELETION(CRUD)]");
		System.out.println("11)- Delete Movies By Ids                                                         [DELETION-ALL-BY-ID(CRUD)]");
		System.out.println("12)- Delete All Movie                                                                [DELETION-ALL(CRUD)]");
		System.out.println("13)- SelectAll Movie(sorted)                                                    [SELECT-ALL-SORTED(CRUD)]");
		System.out.println("14)- GetPage                                                                             [GET_PAGE(PAS)");
		System.out.println("15)- SortAndGetPage                                                               [SORT_AND_GET_PAGE(PAS)]");
		System.out.println("16)- FindOne                                                                             [FIND ONE(JPA)]");
		System.out.println("17)- FindAll                                                                                [FIND ALL(JPA)]");
		System.out.println("18)- Delete Movies By Ids                                                        [DELETE ALL(JPA)(SINGLE QUERY)]");
		System.out.println("19)- GetMovieByMovieName                                                 [GetMovieByName(JPA)]");
		System.out.println("20)- GetMovieByActorName                                                   [GetMovieByActorName(JPA)]");
		System.out.println("21)- GetMovieByMovieNameStartingWith                           GetMovieBy(JPA)]");
		System.out.println("22)- GetMovieByMovieNameEndingWith                             [GetMovieByActorName(JPA)]");
		System.out.println("23)- FetchMovieByActorAndActressName                            [FetchMovieByActorAndActressName(JPA)]");
		System.out.println("24)- FetchMovieByActorAndActressNameV2                       [FetchMovieByActorAndActressNameV2(JPA)]");
		System.out.println("25)- FetchMovieByActorAndActressNameV3                       [FetchMovieByActorAndActressNameV3(JPA)]");
		System.out.println("26)- FetchReleaseDateByMovieName                                   [FetchMovieReleaseDataByMovieName(JPA)]");
		System.out.println("27)- FetchActorAndActressByMovieName                           [FetchActorAndActressByMovieName(JPA)]");
		System.out.println("0)- Exit App                                          [EXIT]");
		getAndProcessInput();
	}
	
	public void getAndProcessInput()
	{
		int ch = getInput("Enter option:-", 0);
		Movie mov =null;
		Iterable<Movie> movies = null;
		boolean result=false;
		String newMovieName;
		String newMovie1Name;
		
		switch (ch) {
			case 1:
			mov = getMovie();
			mov =  movieService.saveMovie_CrudRepo(mov);
			System.out.println("Saved (Movie) :-"+mov);
			showMenu(false);
			break;
			
			case 2:
				movies =  movieService.findAllMovie_CrudRepo();
				movies.forEach(System.out::println);
				showMenu(false);
				break;
				
			case 3:
				ch = getInput("Enter movie id:-", 0);
				System.out.println(movieService.findByIdMovie_CrudRepo(ch));
				showMenu(false);
				break;
				
			case 4:
				ch = getInput("Enter movie id:-", 0);
				try 
				{
					System.out.println("find movie:-"+movieService.findByIdMovieVersion2_CrudRepo(ch));
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
				movies = movieService.findAllByIdMovie_CrudRepo(al);
				movies.forEach(System.out::println);
				showMenu(false);
				break;
				
			case 6:
				System.out.println("Total Movies: "+movieService.getTotalMovieInDB_CrudRepo());
				showMenu(false);
				break;
				
			case 7:
				ch = getInput("Enter movie id:-", 0);
				result = movieService.existsByIdMovie_CrudRepo(ch);
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
				
				movies =  movieService.saveAllMovie_CrudRepo(list);
				System.out.println("Saved Movies below:-");
				movies.forEach(System.out::println);
				showMenu(false);
				break;
				
			case 9:
				ch = getInput("Enter movie id [for update]:-", 0);
				newMovieName= getInput("Enter movie new name:- ","");
				try 
				{
					String msg= movieService.updateMovieName_CrudRepo(ch, newMovieName);
					System.out.println(msg);
				}
				catch (Exception e) {e.printStackTrace();}
				showMenu(false);
				break;
				
			case 10:
				ch = getInput("Enter movie id [for delete]:-", 0);
				String msg = movieService.deleteByIdMovie_CrudRepo(ch);
				System.out.println(msg);
				showMenu(false);
				break;
				
			case 11:
				al = new ArrayList<>();
				while(true)
				{
					ch = getInput("Enter movie id (-1 to exit):-", 0);
					if(ch<0)
					break;
					al.add(ch);
				}
				System.out.println(movieService.deleteAllByIdMovie_CrudRepo(al));
				showMenu(false);
				break;
				
			case 12:
				System.out.println(movieService.deleteAll_CrudRepo());
				showMenu(false);
				break;
				
			case 13:
				movies = movieService.findAllMovie_PAS(true, "movieReleaseDate");
				movies.forEach(System.out::println);
				showMenu(false);
				
			case 14:
				ch = getInput("Enter page no[Starting from zero]:-", 0);
				int pageSize = getInput("Enter page size:-", 0);
				Page<Movie> page = movieService.getPage_PAS(ch++,pageSize);
				showPageMetaData(page);
				while(page.hasNext())
				{
				    System.out.println("\n");
					newMovieName = getInput("TYPE [CONTINUE] FOR NEXT PAGE LOAD","");
					if(!newMovieName.equalsIgnoreCase("continue"))
						break;
					page = movieService.getPage_PAS(ch++,pageSize);
					showPageMetaData(page);
				}
				showMenu(false);
				break;
				
			case 15:
				ch = getInput("Enter page no[Starting from zero]:-", 0);
				pageSize = getInput("Enter page size:-", 0);
				page = movieService.sortAndGetPage_PAS(ch++,pageSize,true,"movieActor");
				showPageMetaData(page);
				while(page.hasNext())
				{
				    System.out.println("\n");
					newMovieName = getInput("TYPE [CONTINUE] FOR NEXT PAGE LOAD","");
					if(!newMovieName.equalsIgnoreCase("continue"))
						break;
					page = movieService.sortAndGetPage_PAS(ch++,pageSize,true,"movieActor");
					showPageMetaData(page);
				}
				showMenu(false);
				break;
				
			case 16:
				Movie movie = new Movie();
				movie.setMovieName("don");
				mov =  movieService.findOneMovie_JPA(movie);
				System.out.println("movie:-"+mov);
				showMenu(false);
				
			case 17:
				movie = new Movie();
				movie.setMovieActress("juhi");
				movies = movieService.findAllMovie_JPA(movie);
				movies.forEach(System.out::println);
				showMenu(false);
				
			case 18:
				al = new ArrayList<>();
				while(true)
				{
					ch = getInput("Enter movie id (-1 to exit):-", 0);
					if(ch<0)
					break;
					al.add(ch);
				}
				System.out.println(movieService.deleteAllByIdInBatchMovie_JPA(al));
				showMenu(false);
			break;
			
			case 19:
				newMovieName = getInput("Enter movie name...", "");
				System.out.println(movieService.getMovieByMovieName_JPA(newMovieName));
				showMenu(false);
				break;
				
			case 20:
				newMovieName = getInput("Enter actor name...", "");
				movieService.getMoviesByActorName_JPA(newMovieName).forEach(System.out::println);
				showMenu(false);
				break;
				
			case 21:
				newMovieName = getInput("Enter movie  name starting with...", "");
				movieService.getMovieByMovieNameStartingWith_JPA(newMovieName).forEach(System.out::println);
				showMenu(false);
				break;
				
			case 22:
				newMovieName = getInput("Enter movie name ending with...", "");
				movieService.getMovieByMovieNameEndingWith_JPA(newMovieName).forEach(System.out::println);
				showMenu(false);
				break;
				
			case 23:
				newMovieName = getInput("Enter actor name.", "");
				newMovie1Name = getInput("Enter actess name","");
				movieService.fetchMoviesByActorAndAcress(newMovieName,newMovie1Name).forEach(System.out::println);
				showMenu(false);
				break;
				
			case 24:
				newMovieName = getInput("Enter actor name.", "");
				newMovie1Name = getInput("Enter actess name","");
				movieService.fetchMoviesByActorV2(newMovieName,newMovie1Name).forEach(System.out::println);
				showMenu(false);
				break;
				
			case 25:
				newMovieName = getInput("Enter actor name.", "");
				newMovie1Name = getInput("Enter actess name","");
				movieService.fetchMoviesByActorV3(newMovieName,newMovie1Name).forEach(System.out::println);
				showMenu(false);
				break;
				
			case 26:
				newMovieName = getInput("Enter movie name.", "");
				System.out.println(movieService.fetchReleaseDateByMovieName(newMovieName).toString());
				showMenu(false);
				break;
				
			case 27:
				newMovieName = getInput("Enter movie name.", "");
				System.out.println(movieService.fetchActorAndActressByMovieName(newMovieName));
				showMenu(false);
				break;
				
			default:
			System.out.println("Invalid Inputs\nBye, See you again!!!");
		}
	}
	
	private void showPageMetaData(Page<Movie> page)
	{
		System.out.println("\n\n");
		System.out.println("-----------PAGE:-"+(page.getNumber()+1)+"-------------");
		System.out.println("total pages: "+page.getTotalPages());
		System.out.println("page number: "+page.getNumber());
		System.out.println("is_First_Page: "+page.isFirst());
		System.out.println("is_Last_Page: "+page.isLast());
		System.out.println("is_Empty_Page: "+page.isEmpty());
		System.out.println("number of elements in page: "+page.getNumberOfElements());
		page.forEach(System.out::println);
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
	
}
