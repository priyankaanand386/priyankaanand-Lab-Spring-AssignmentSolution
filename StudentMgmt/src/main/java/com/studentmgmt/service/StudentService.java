package com.studentmgmt.service;

import java.util.List;

import com.studentmgmt.model.Student;

public interface StudentService {

	List<Student> findAllStudents();
	Student findStudentById(Integer studentId);
	void saveStudent(Student student);
	void deleteStudentById(Integer studentId);
	
}
