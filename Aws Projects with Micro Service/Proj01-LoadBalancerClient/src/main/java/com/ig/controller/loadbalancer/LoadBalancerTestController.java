package com.ig.controller.loadbalancer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/load-balancer")
public class LoadBalancerTestController 
{
	@Autowired
	LoadBalancerClient lb;
	
	@GetMapping("/find/{name}")
	public String find(@PathVariable String name)
	{
		ServiceInstance instance =  lb.choose(name);
		 if(instance==null)
		 {
			 return "No Services found !!!";
		 }
		 
		 String serviceUrl = instance.getUri().toString();
		 serviceUrl+="/security-test/test-token";
		 
		 RestTemplate template = new RestTemplate();
		 ResponseEntity<String> response =  template.getForEntity(serviceUrl, String.class);
		 
		return response.getBody();
	}
}
