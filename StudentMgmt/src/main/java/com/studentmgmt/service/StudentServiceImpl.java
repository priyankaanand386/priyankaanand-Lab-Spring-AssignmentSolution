package com.studentmgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmgmt.model.Student;
import com.studentmgmt.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> findAllStudents() {
		 return studentDao.findAll();
	}

	@Override
	public Student findStudentById(Integer studentId) {
		 Optional<Student> studentOptional = studentDao.findById(studentId);
		 if( studentOptional.isPresent() ) {
			 return studentOptional.get();
		 } 
		 return null;
	}

	@Override
	public void saveStudent(Student student) {
		studentDao.save(student);
	}

	@Override
	public void deleteStudentById(Integer studentId) {
		studentDao.deleteById(studentId);
	}

}
