package com.ig.ms;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish-api")
public class WishMessageAPIHandler 
{
	@Value("${spring.application.instance-id}")
	public String instanceId;
	
	@GetMapping("/wish")
	public ResponseEntity<String> getWishMessage()
	{
		return new ResponseEntity<String>("good morning user:-"+instanceId,HttpStatus.OK);
	}
}
