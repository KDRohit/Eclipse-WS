package com.ig.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@DynamoDbBean
public class Movie 
{
	private String id;
	private String name;
	
	@DynamoDbPartitionKey
	public String getId() 
	{
		return id;
	}
	
	public void setId(String Id) 
	{
		this.id = Id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
}
