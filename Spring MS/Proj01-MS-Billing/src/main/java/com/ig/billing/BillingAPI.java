package com.ig.billing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/billing")
@RefreshScope
public class BillingAPI 
{
	@Value("${db.user}")
	public String dbUser;
	@Value("${db.pass}")
	public String dbPass;
	
	@Value("${spring.application.instance-id}")
	public String instanceId;
	
	@Value("${server.port}")
	public String port;
	
	@GetMapping("/fetch")
	public ResponseEntity<String> fetchBillingDetails()
	{
		String msg = "Final Amount = BillAmt - discount(Rs.5000)"
				+ " :: using instance ::->"+instanceId
				+ " :: @port::"+port
				+ " :: DB_USER::"+dbUser
				+ " :: DB_PASS::"+dbPass;
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
