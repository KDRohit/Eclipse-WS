package com.ig.shoping;
import java.net.URI;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceLoadBalancerConsumer 
{
	@Autowired
	private LoadBalancerClient client;
	
	public String getBillingInfo()
	{
		ServiceInstance instance =  client.choose("Billing-Service");
		System.out.println("--------------BILLING SERVICE URL--------------------");
		System.out.println(instance.getUri()+"/api/billing/fetch");
		
		
		String  url = instance.getUri().toString()+"/api/billing/fetch";
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> response =   rt.getForEntity(url, String.class);
		String responseBody = response.getBody();
		return responseBody;
	}
	
}
