package com.ig.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "FCM-Module")
public interface IFCMService {
	@PostMapping("notifications/send")
	public String sendNotification(
			@RequestParam String token,
    		@RequestParam String title,
    		@RequestParam String body);
}
