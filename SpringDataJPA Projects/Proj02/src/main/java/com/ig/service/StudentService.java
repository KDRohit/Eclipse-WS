package com.ig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.entity.PhoneNumber;
import com.ig.entity.Student;
import com.ig.repo.IPhoneNumberRepo;
import com.ig.repo.IStudentRepo;

@Service
public class StudentService
{
	@Autowired
	private IStudentRepo istudRepo;
	
	@Autowired
	private IPhoneNumberRepo iphoneRepo;
	
	public String saveStudent(Student entity)
	{
		Student  saved = istudRepo.save(entity);
		return "Saved Entity(StudentEntity) with Id["+saved.getStudentId()+"]";
	}
	
	public String savePhoneNum(Integer sid, PhoneNumber entity)
	{
		Student s =  findStudentById(sid);
		entity.setStudent(s);
		PhoneNumber  saved = iphoneRepo.save(entity);
		return "Saved Entity(PhoneNumEntity) with Id["+saved.getPhoneId()+"]";
	}
	
	public Student findStudentById(Integer id)
	{
		Student  result = istudRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Student id"+id));
		return result;
	}
	
	public PhoneNumber findPhonetById(Integer id)
	{
		PhoneNumber  result = iphoneRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Phone id"+id));
		return result;
	}
	
	public Iterable<Student> findAll()
	{
		return istudRepo.findAll();
	}
}
