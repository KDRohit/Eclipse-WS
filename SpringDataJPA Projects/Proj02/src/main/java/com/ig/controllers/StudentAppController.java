package com.ig.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import com.ig.entity.PhoneNumber;
import com.ig.entity.Student;
import com.ig.service.StudentService;

@Controller("studentController")
@Profile({"collections-in-mysql"})
public class StudentAppController implements AppController
{
	@Autowired
	private StudentService service;
	
	@Override
	public void showMenu(boolean isFirst) 
	{
		if(isFirst)
		{
			System.out.println("Welcome in the app:-\n ------Student Management-------------");
		}
		System.out.println("Menu(Items):-");
		System.out.println("1)- Save Student                                                                           [SAVE(CRUD)]");
		System.out.println("2)- Save PhoneNum                                                                     [SAVE(CRUD)]");
		System.out.println("3)- Get  StudentWithPhone By Id                                               [SELECT(CRUD)]");
		System.out.println("4)- Get  PhoneWithStudent By Id                                               [SELECT(CRUD)]");
		System.out.println("5)- Select All Student                                                                   [FINDALL(CRUD)]");
		getAndProcessInput();
	}

	@Override
	public void getAndProcessInput() 
	{
		int ch = getInput("Enter option:-", 0);
		Student stu;
		PhoneNumber ph;
		
		try
		{
			switch (ch) 
			{
				case 1:
				stu = getStudent();
				System.out.println(service.saveStudent(stu));
				showMenu(false);
				break;
				
				case 2:
					ch = getInput("Enter Student Id:-", 0);
					ph = getPhoneNum();
					System.out.println(service.savePhoneNum(ch,ph));
					showMenu(false);
					break;
				
				case 3:
					ch = getInput("Enter Student Id",0);
					stu =  service.findStudentById(ch);
					System.out.println(stu);
					stu.getPhoneNumbers().forEach(System.out::println);
					showMenu(false);
					break;
					
				case 4:
					ch = getInput("Enter Phone Id",0);
					ph =  service.findPhonetById(ch);
					System.out.println("-----PHONE NUMBER-----------------------");
					System.out.println(ph);
					System.out.println("-----STUDENT DETAILS-----------------------");
					System.out.println(ph.getStudent());
					System.out.println("-----STUDENT PHONE NUMBERS [ALL]-----------------------");
					ph.getStudent().getPhoneNumbers().forEach(System.out::println);
					showMenu(false);
					break;
					
				case 5:
					service.findAll().forEach(System.out::println);
					showMenu(false);
					break;
			}
		}
		catch (Exception e)
		{
			System.out.println("\n Error [Message] : "+e.getMessage());
			showMenu(false);
		}
	}
	
	private Student getStudent()
	{
		String name = getInput("Enter Student name:-", "");
		List<String> friends = new ArrayList<String>();
		String friend = getInput("Enter Friend name:-", "");
		while(!friend.isEmpty() && !friend.equalsIgnoreCase("exit"))
		{
			friends.add(friend);
			friend = getInput("Enter Another Friend name [EXIT/exit] :-", "");
		}
		
		Student stu = new Student(name,friends);
		List<PhoneNumber> phoneNums = new ArrayList<PhoneNumber>();
		String phNum = getInput("Enter your phone no[EXIT/exit]:-", "");
		while(!phNum.isEmpty() && !phNum.equalsIgnoreCase("exit"))
		{
			PhoneNumber phoneNumber = new PhoneNumber();
			phoneNumber.setPhoneNo(phNum);
			phoneNumber.setStudent(stu);
			phoneNums.add(phoneNumber);
			phNum = getInput("Enter your phone no[EXIT/exit]:-", "");
		}
		stu.setPhoneNumbers(phoneNums);
		return stu;
	}
	
	private PhoneNumber getPhoneNum()
	{
		String phNum = getInput("Enter your phone no:-", "");
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setPhoneNo(phNum);
		return phoneNumber;
	}


}
