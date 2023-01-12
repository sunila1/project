package com.luv2code.springboot.crudedemo.service;

import java.util.List;


import com.luv2code.springboot.crudedemo.entity.student;

public interface StudentService {
	
public List<student> findAll();
	
	public student findById(int theNo);
	
	public void save( student thestudent);
	
	public void deleteById( int theNo);

}
