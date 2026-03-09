package com.ig.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ig.entity.IQuizRepo;
import com.ig.entity.QuizEntity;
import com.ig.response.QuizVO;
import com.ig.response.Response;
import com.ig.service.ILoginService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/game")
public class GameController
{
	@Autowired IQuizRepo quizRepo;
	
	@Autowired ILoginService loginService;
	
	@CircuitBreaker(name="onTest",fallbackMethod = "loginServiceIsBusy")
	@GetMapping("/test")
	public Response<Boolean> test()
	{		
		//Response result =  new Response("200", "Token Validated", true);
		String header = "dkfijeiofjefer.dkjfidfjdofjdofj.kjdfidjfoidjfodif";
		Response<Boolean> result =  loginService.checkToken(header);
		return result;
	} 
	
	public Response<Boolean> loginServiceIsBusy(Exception e)
	{
		return new Response("200","Ohh !! It looks like Login Service is Busy",false);
	}
	
	@GetMapping("/save/{que}/{opt1}/{opt2}/{opt3}/{opt4}/{ans}")
	public Response<QuizEntity> save(
			@PathVariable String que, 
			@PathVariable String opt1, 
			@PathVariable String opt2, 
			@PathVariable String opt3, 
			@PathVariable String opt4, 
			@PathVariable Integer ans
			)
	{
		QuizEntity entity = new QuizEntity(que, opt1, opt2, opt3, opt4, ans);
		QuizEntity saved =  quizRepo.save(entity);
		return new Response("200","Quiz is Saved",saved);
	}
	
	@GetMapping("/play/{quesNo}")
	public Response<QuizVO> play(@PathVariable Integer quesNo)
	{
		List<QuizEntity> list =  quizRepo.findAll();
		quesNo=quesNo<=0?1:quesNo;
		int validIndex = (quesNo - 1) % list.size();
		QuizEntity quiz = list.get(validIndex);
		System.out.println("quiz :: "+quiz);
		QuizVO vo = new QuizVO();
		BeanUtils.copyProperties(quiz, vo);
		return new Response<QuizVO>("200","Play the quiz !!!",vo);
	}
	
	@GetMapping("/play/{queId}/{ans}")
	public Response<Boolean> answer(@PathVariable Integer queId,@PathVariable Integer ans)
	{
		Optional<QuizEntity> opt =  quizRepo.findById(queId);
		if(opt.isPresent())
		{
			QuizEntity quiz = opt.get();
			if(quiz.getAns().equals(ans))
			{
				return new Response("200","Congratulation! Answer is correct",true);
			}
		}
		return new Response("200","Ohh !! Answer is incorrect",false);
	}
}
