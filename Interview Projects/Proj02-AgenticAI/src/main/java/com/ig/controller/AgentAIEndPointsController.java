package com.ig.controller;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ai/")
public class AgentAIEndPointsController 
{
	private ChatClient chatClient;
	public AgentAIEndPointsController(ChatClient.Builder builder) 
	  {
	        this.chatClient = builder.build();
	  }
	  
	@GetMapping("/ask")
	public String ask(@RequestParam String ques)
	{
		return chatClient.prompt().user(ques).call().content();
	}
}
