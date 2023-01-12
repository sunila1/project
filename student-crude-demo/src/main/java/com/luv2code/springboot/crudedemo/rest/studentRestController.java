package com.luv2code.springboot.crudedemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.crudedemo.entity.student;
import com.luv2code.springboot.crudedemo.service.StudentService;

@RestController
@RequestMapping("/api")
public class studentRestController {
	
	private StudentService theStudentService;
	
	@Autowired
	public studentRestController(StudentService studentService)
	{
		this.theStudentService=studentService;
	}
	
	
	@GetMapping("/students")
	public List<student> findAll()
	{
		return theStudentService.findAll();
	}

	//add mapping for get/studentss/{studentsId}
	@GetMapping("/students/{studentNo}")
	public student getStudent(@PathVariable int studentNo) 
	{
		student thestudent = theStudentService.findById(studentNo);
		if(thestudent==null)
		{throw new RuntimeException("student no is not found" + studentNo);}
		return thestudent;
		
	}
	//add mapping to save new students
	@PostMapping("/students")
	public student addStudent(@RequestBody student thestudent)
	{
		thestudent.setStudentNo(0);
		theStudentService.save(thestudent);
		return thestudent;
	}
	//add mapping for put students
	
	@PutMapping("/students")
	public student updatestudents(@RequestBody student thestudent)
	{
		theStudentService.save(thestudent);
		return thestudent;
	}
	@DeleteMapping("/students/{studentNo}")
	public String deletestudent(@PathVariable int studentNo)
	{
		student tempstudent = theStudentService.findById(studentNo);
		if(tempstudent==null)
		{
			throw new RuntimeException("emp id not found" +studentNo);
		}
		theStudentService.deleteById(studentNo);
		return "deleted studentno is"+studentNo;
	}
	
	
	
	
	
	
}
