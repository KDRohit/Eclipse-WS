package com.ig.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.entity.Movie;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;

@Service
public class DynamoDbClientService
{
	@Autowired
	public DynamoDbClient dynamoDbClient;
	
	@Autowired
	public DynamoDbEnhancedClient dynamoDbEnhancedClient;
	
	public final String MOVIE_TABLE_NAME = "Movies";
	
	
	//public 
	
	public  List<Movie> getAllMovies()
	{
		ScanRequest scRequest = ScanRequest.builder().tableName(MOVIE_TABLE_NAME).build();
		List<Map<String,AttributeValue>> items = dynamoDbClient.scan(scRequest).items();
	    List<Movie> movies = new ArrayList<>();
		
	    movies = items.stream().map
		(
				map->
				{
					 Movie movie = new Movie();

	                if (map.containsKey("Id")) {
	                    movie.setId(map.get("Id").s());
	                }

	                if (map.containsKey("name")) {
	                    movie.setName(map.get("name").s());
	                }

		                return movie;
				}
		)
		.collect(Collectors.toList());
		return movies;
	}
	
	public Movie saveMovie(String name)
	{
		Map<String, AttributeValue> item = new HashMap();
		
		AttributeValue attributeValue1 = 
				AttributeValue.builder().s
				(
						UUID.randomUUID().toString()
				).
		build();
		
		AttributeValue attributeValue2 = 
				AttributeValue.builder().s
				(
						name
				).
				build();
		
		item.put("Id",attributeValue1);
		item.put("name",attributeValue2);
		
		PutItemRequest request = PutItemRequest.builder()
                .tableName(MOVIE_TABLE_NAME)
                .item(item)
                .build();

		dynamoDbClient.putItem(request);
		return new Movie(attributeValue1.s(), attributeValue2.s());
	}
}
