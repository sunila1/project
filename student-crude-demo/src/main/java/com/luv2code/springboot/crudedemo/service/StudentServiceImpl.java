package com.luv2code.springboot.crudedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.luv2code.springboot.crudedemo.dao.StudentDAO;
import com.luv2code.springboot.crudedemo.entity.student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentDAO studentDAO;
	
	@Autowired
	public StudentServiceImpl(StudentDAO theStudentDAO)
	{
		this.studentDAO =theStudentDAO;
	}
	
	@Transactional
	@Override
	public List<student> findAll() {
		
		return studentDAO.findAll();
	}

	@Transactional
	@Override
	public student findById(int theNo) {
		
		return studentDAO.findById(theNo);
	}

	@Transactional
	@Override
	public void save(student thestudent) {
		studentDAO.save(thestudent);

	}

	@Transactional
	@Override
	public void deleteById(int theNo) {
		studentDAO.deleteById(theNo);

	}

}
