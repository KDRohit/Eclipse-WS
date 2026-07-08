package com.ig.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;

@Configuration
public class CognitoConfig 
{
	@Bean
	public CognitoIdentityProviderClient cognitoClient() {

	    AwsBasicCredentials credentials = AwsBasicCredentials.create(
	            "AKIAXERUFZJPNR3EBEFW",
	            "dufri0dBFmA8YWwmn1O08Zolkvlsrn43Vfkn+znh"
	    );

	    return CognitoIdentityProviderClient.builder()
	            .region(Region.AP_SOUTH_1)
	            .credentialsProvider(
	                    StaticCredentialsProvider.create(credentials))
	            .build();
	}
}
