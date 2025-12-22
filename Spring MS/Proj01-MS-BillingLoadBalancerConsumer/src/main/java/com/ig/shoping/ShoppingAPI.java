package com.ig.shoping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/shopping")
public class ShoppingAPI
{
	@Autowired
	private BillingServiceLoadBalancerConsumer billingClient;
	
	@GetMapping("/cart")
	public ResponseEntity<String> doShopping()
	{
		String billingInfo = billingClient.getBillingInfo();
		try {Thread.sleep(2000);}
		catch (Exception e) {	e.printStackTrace();}
		return new ResponseEntity<String>("shoping items :: {T-Shirt,trouser }, billing details :: "+billingInfo,HttpStatus.OK);
	}
}
