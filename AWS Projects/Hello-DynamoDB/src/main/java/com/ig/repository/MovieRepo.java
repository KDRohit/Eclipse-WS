package com.ig.repository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ig.entity.Movie;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.mapper.BeanTableSchema;
import software.amazon.awssdk.enhanced.dynamodb.mapper.StaticTableSchema;

@Repository
public class MovieRepo 
{
	private final String MOVIE_TABLE_NAME = "Movies";
	private final DynamoDbTable<Movie> dynamoDbMovieTable;
	
	public MovieRepo(DynamoDbEnhancedClient dynamoDbEnhancedClient)
	{
	    BeanTableSchema<Movie> movieTableSchema =  TableSchema.fromBean(Movie.class);
	    dynamoDbMovieTable = dynamoDbEnhancedClient.table(MOVIE_TABLE_NAME, movieTableSchema);
	}
	
	public List<Movie> getAll()
	{
		return dynamoDbMovieTable.scan().items().stream().toList();
	}
	
	public Movie save(Movie movie)
    {
		dynamoDbMovieTable.putItem(movie);
		return movie;
    }
	
	public Movie update(Movie movie)
	{
		dynamoDbMovieTable.updateItem(movie);
		return movie;
	}
	
	public Movie getById(Movie mov)
	{
		return dynamoDbMovieTable.getItem(mov);
	}
}
