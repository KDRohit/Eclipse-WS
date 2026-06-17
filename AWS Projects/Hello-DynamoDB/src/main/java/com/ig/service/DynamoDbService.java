package com.ig.service;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.entity.Movie;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

@Service
public class DynamoDbService 
{
	@Autowired
	public DynamoDbClient dynamoDbClient;
	
	public final String MOVIE_TABLE_NAME = "Movies";
	
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
		
		item.put("Id ",attributeValue1);
		item.put("name ",attributeValue2);
		
		PutItemRequest request = PutItemRequest.builder()
                .tableName(MOVIE_TABLE_NAME)
                .item(item)
                .build();

		dynamoDbClient.putItem(request);
		return new Movie(attributeValue1.s(), attributeValue2.s());
	}
}
