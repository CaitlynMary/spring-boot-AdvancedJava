package com.example.Customquery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Customquery.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

	
	@Query("Select s from Student s where s.name= :name")
	public Student findByName(@Param("name") String name);
	
	public List<Student> findByAgeGreaterThan(Integer age);
}

