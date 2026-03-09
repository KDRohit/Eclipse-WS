package com.ig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ig.service.FCMService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private FCMService fcmService;

    @PostMapping("/send")
    public String sendNotification(@RequestParam String token) throws Exception {

        return fcmService.sendNotification(
                token,
                "Hello",
                "Notification from Spring Boot"
        );
    }
}
