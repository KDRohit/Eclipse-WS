package com.ig.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDbConfig
{
	    //@Value("${aws.access-key-id}")
	    //private String accessKey;

	    //@Value("${aws.secret-access-key}")
	    //private String secretKey;
	
	@Bean
	public DynamoDbEnhancedClient dynamoDbEnhancedClient(DynamoDbClient dynamoDbClient)
	{
		return DynamoDbEnhancedClient
				.builder()
				.dynamoDbClient(dynamoDbClient)
				.build();
	}
	
	@Bean
	 public DynamoDbClient dynamoDbClient()
	 {
//		 return DynamoDbClient
//				 .builder()
//				 .region(Region.AP_SOUTH_1)
//				 .credentialsProvider(
//								 StaticCredentialsProvider.create
//								 (AwsBasicCredentials.create(accessKey, secretKey))
//						 )
//				 .build();
		 
//		 return DynamoDbClient
//				 .builder()
//				 .region(Region.AP_SOUTH_1)
//				 .credentialsProvider(
//								 DefaultCredentialsProvider.builder().build()
//						 )
//				 .build();
		 
		 return DynamoDbClient
				 .builder()
				 .region(Region.AP_SOUTH_1)
				 .build();
	 }
}
