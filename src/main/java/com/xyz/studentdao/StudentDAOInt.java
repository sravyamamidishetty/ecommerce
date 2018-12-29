package com.xyz.studentdao;

import java.util.List;

import com.xyz.model.Student;

public interface StudentDAOInt {

	public boolean addStudent(Student s);

	public List<Student> getAllStudent();
	
	public abstract Student validateStudent(Student s);
	
	
	
}
