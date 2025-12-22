package com.ig.billing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/billing")
public class BillingAPI 
{
	@Value("${spring.application.instance-id}")
	public String instanceId;
	
	@Value("${server.port}")
	public String port;
	
	@GetMapping("/fetch")
	public ResponseEntity<String> fetchBillingDetails()
	{
		String msg = "Final Amount = BillAmt - discount(Rs.5000)"
				+ " :: using instance ::->"+instanceId
				+ " :: @port::"+port;
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
