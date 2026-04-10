package com.example.Customquery.testcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Customquery.entity.Student;
import com.example.Customquery.service.StudentService;

@RestController
public class TestController {

	@Autowired
	StudentService service;
	
	@GetMapping("/search/{name}")
	public Student fetchStudent(@PathVariable String name) {
		return service.getByName(name);
	}
	
	@GetMapping("/fetch/{age}")
	List<Student> searchByAge(@PathVariable Integer age){
		return service.getByAge(age);
	}
	@GetMapping("/exc/{id}")
	public Student getById(@PathVariable Integer id) {
		return service.getById(id);
	}
}
