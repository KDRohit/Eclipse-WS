package com.ig.external.comunication;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/discovery-client")
public class DiscoveryClientTest
{
	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping("/find/{name}")
	public String find(@PathVariable String name)
	{
		 List<ServiceInstance> services =  discoveryClient.getInstances(name);
		 if(services.size()==0)
		 {
			 return "No Services found !!!";
		 }
		 
		 ServiceInstance instance = services.get(0);
		 String serviceUrl = instance.getUri().toString();
		 serviceUrl+="/security-test/test-token";
		 
		 RestTemplate template = new RestTemplate();
		 ResponseEntity<String> response =  template.getForEntity(serviceUrl, String.class);
		 
		return response.getBody();
	}
}
