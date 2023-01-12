package com.luv2code.springboot.crudedemo.dao;

import java.util.List;


import com.luv2code.springboot.crudedemo.entity.student;

public interface StudentDAO {
	
	public List<student> findAll();
	
	public student findById(int StudentNo);
	
	public void save( student thestudent);
	
	public void deleteById( int theNo);

}
