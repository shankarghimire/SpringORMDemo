package com.springorm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class Student {

	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	
	@Column(name="student_name")
	private String name;
	
	@Column(name="student_city")
	private String studentCity;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int studentId, String name, String studentCity) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.studentCity = studentCity;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStudentCity() {
		return studentCity;
	}
	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", studentCity=" + studentCity + "]";
	}
	
}
