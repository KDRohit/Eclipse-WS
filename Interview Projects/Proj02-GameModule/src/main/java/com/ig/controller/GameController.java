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
import com.ig.service.IFCMService;
import com.ig.service.ILoginService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/game")
public class GameController
{
	@Autowired IQuizRepo quizRepo;
	@Autowired ILoginService loginService;
	@Autowired IFCMService fcmService;
	
	final String adminToken=
			"fTnAasS6SnGOjJMpmra4CN:APA91bGM8gbdW0jDrCS4-AKH6VPBNj9hYT-VMUnlbR0WjYEtzFGtV5Y456o8wo9t01Hadq8TvyRZ-NzGzNiu6fJJr5Y4VfmsqnSV91GA4coVy4FURbewSWU";
	
	@CircuitBreaker(name="onTest",fallbackMethod = "loginServiceIsBusy")
	@GetMapping("/test")
	public Response<Boolean> test()
	{
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
		fcmService.sendNotification(adminToken, "EndPoint::game/save", "New Quiz is Saved");
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
		fcmService.sendNotification(adminToken, "EndPoint::game/play", "Play the quiz !!!");
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
				fcmService.sendNotification(adminToken, "EndPoint::game/play", "Congratulation! Answer is correct");
				return new Response("200","Congratulation! Answer is correct",true);
			}
		}
		fcmService.sendNotification(adminToken, "EndPoint::game/play", "Ohh !! Answer is incorrect");
		return new Response("200","Ohh !! Answer is incorrect",false);
	}
}
