package com.studentmanagement.service;

import java.util.List;

import com.studentmanagement.entity.Student;

public interface StudentService {

	List<Student> getAllStudent();

	void addStudent(Student student);

	Student getStudent(int studId);

	void updateStudent(int studId, Student student);

	void deleteStudent(int studid);
	

}