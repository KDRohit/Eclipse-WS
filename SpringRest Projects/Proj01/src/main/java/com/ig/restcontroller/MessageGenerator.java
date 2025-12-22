package com.ig.restcontroller;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageGenerator 
{
	@GetMapping("/")
	public ResponseEntity<Entity> GetMappingMessage()
	{
		Entity entity = new Entity("welcome",HttpStatus.OK);
		return new ResponseEntity<Entity>(entity,HttpStatus.OK);
	}
	
}
