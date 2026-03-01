package com.ig.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import com.ig.response.Response;

@FeignClient(name = "Login-Module")
public interface ILoginService {
	
	@GetMapping("auth/validate")
	public Response<Boolean> checkToken(@RequestHeader("Authorization") String authorizationHeader);

}
