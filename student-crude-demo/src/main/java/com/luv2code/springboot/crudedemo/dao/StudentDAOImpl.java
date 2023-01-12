package com.luv2code.springboot.crudedemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.crudedemo.entity.student;

import jakarta.persistence.EntityManager;



@Repository

public class StudentDAOImpl implements StudentDAO {
	
	//define field for entity manager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public  StudentDAOImpl(EntityManager theEntityManager)
	{
		this.entityManager=theEntityManager;
	}

	@Override
	
	public List<student> findAll() {
		
		//get the current session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		Query<student> theQuery = currentSession.createQuery("from student",student.class);
		
		//execute a query
		List<student>students = theQuery.getResultList();
		//return results
	
		return students;
	}

	@Override
	public student findById(int theNo) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//get the student
		student thestudent=currentSession.get(student.class,theNo);
		//return the student
		return thestudent;
	}

	
	@Override
	public void save(student thestudent) {
		//get the current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
				//get the student
				currentSession.persist(thestudent);
		
	}

	@Override
	public void deleteById(int theNo) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from student where student_no=:studentNo");
		theQuery.setParameter("studentNo", theNo);
		theQuery.executeUpdate();
		
	}

}
