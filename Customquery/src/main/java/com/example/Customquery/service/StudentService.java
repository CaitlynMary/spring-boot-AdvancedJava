package com.example.Customquery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Customquery.entity.Student;
import com.example.Customquery.exception.StudentExceptionHandler;
import com.example.Customquery.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentrepo;
	
	public StudentService() {
		
	}
	
	public Student getByName(String name) {
		return studentrepo.findByName(name);
	}
	
	public List<Student> getByAge(Integer age){
		return studentrepo.findByAgeGreaterThan(age);
	}
	
	public Student getById(Integer id) {
		Optional<Student> optional=studentrepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new StudentExceptionHandler("Student not found");
		}
	}
}
