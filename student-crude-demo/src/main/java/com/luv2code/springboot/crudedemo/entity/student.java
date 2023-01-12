package com.luv2code.springboot.crudedemo.entity;

import java.util.Date;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="student")
public class student {
	
	//define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_no")
	private int studentNo;
		
	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getStudentDob() {
		return studentDob;
	}

	public void setStudentDob(Date studentDob) {
		this.studentDob = studentDob;
	}

	public Date getStudentDoj() {
		return studentDoj;
	}

	public void setStudentDoj(Date studentDoj) {
		this.studentDoj = studentDoj;
	}

	@Column(name="student_name")
	private String studentName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="student_dob")
	private Date studentDob;	

	@Temporal(TemporalType.DATE)
	@Column(name="student_doj")
	private Date studentDoj;
		
	
	//define constructors
	public  student() {}

	public student(String studentName, Date studentDob, Date studentDoj) {
		this.studentName = studentName;
		this.studentDob = studentDob;
		this.studentDoj = studentDoj;
	}

	
	
	
	

}
