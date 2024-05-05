package com.studentmanagement.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.entity.Student;
import com.studentmanagement.repository.StudentRepository;
import com.studentmanagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Override
	public List<Student> getAllStudent() {
		return studentRepo.findAll();
	}

	@Override
	public void addStudent(Student student) {
		studentRepo.save(student);
	}

	@Override
	public Student getStudent(int studId) {
		return studentRepo.findById(studId).get();
	}

	@Override
	public void updateStudent(int studId, Student student) {
		Student studdb = studentRepo.findById(studId).get();
		studdb.setStudentId(student.getStudentId());
		studdb.setFirstName(student.getFirstName());
		studdb.setLastName(student.getLastName());
		studdb.setCourse(student.getCourse());
		studdb.setCountry(student.getCountry());
		studdb.setGender(student.getGender());
		studentRepo.save(studdb);
	}
	
	@Override
	public void deleteStudent(int studid) {
		studentRepo.deleteById(studid);
	}

}
