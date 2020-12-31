package com.springorm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springorm.entity.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//Save Student
	@Transactional
	public int insert(Student student) {
	Integer i = (Integer)	this.hibernateTemplate.save(student);
		return i;
	}
	
	//Get the Single record(Object)
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	//Get all Students
	public List<Student> getAllStudents(){
		List<Student> listStudents = this.hibernateTemplate.loadAll(Student.class);
		return listStudents;
	}
	
	//Delete Record
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	
	//Update Record
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	
}
