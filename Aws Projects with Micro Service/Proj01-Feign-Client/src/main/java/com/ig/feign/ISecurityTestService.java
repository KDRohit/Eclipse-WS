package com.ig.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Security-Test-Service")
public interface ISecurityTestService
{
	@GetMapping("/security-test/test-token")
	public String test();
}
