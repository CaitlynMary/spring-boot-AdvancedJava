package com.capSpring.BootProject1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capSpring.BootProject1.controller.Boot1.Employee;
import com.capSpring.BootProject1.structure.ResponseStructure;

@RestController
public class TestController {

	
	@GetMapping("/hi")
	public String m1() {
		return " hiii first Boot Project";
	}
	
	@PostMapping("/hi")
	public String m2() {
		return " hiii first Boot Project";
	}
	//----------------------data using query string---------------
	@GetMapping("/hello")
	public int send(@RequestParam int age) {
		return age;
	}
	
	@GetMapping("/bye")
	public String send1(@RequestParam int age,@RequestParam String name) {
		return age+" "+name;
	}
	
	@PostMapping("/p1")
	public List<String> send2(@RequestParam List<String> product)
	{
		return product;
	}
	
	
	/*********************************************************************************************/
	//----------------- data using path variable--------------
	@PostMapping("/eat/{id}")
	public String send3(@PathVariable int id) {
		return id+" ";
	}
	
	@PostMapping("/eat/{id}/{name}")
	public String send4(@PathVariable int id,@PathVariable String name) {
		return id+" "+name;
	}
	
	@PostMapping("/abc/{myid}/{name}")
	public String send5(@PathVariable(name="myid") int id,@PathVariable String name) {
		return id+" "+name;
	}
	
	@GetMapping("/tea")
	public int send6(@RequestHeader int count) {
		return count;
	}
	@GetMapping("/run")
	public List<String> send7(@RequestHeader List<String> name)
	{
		return name;
		
	}
	@GetMapping("/walk")
	public String send7(@CookieValue String name,@CookieValue String dep) {
		return name+" "+dep;
	}
	
	@GetMapping("/work")
	public Employee add(@RequestBody Employee employee) {
		return employee;
	}
	
	@PostMapping("/try")
	public ResponseStructure<Employee> save(){
		
		ResponseStructure<Employee> rs=new ResponseStructure<Employee>();
		Employee e=new Employee();
		e.setId(10);
		e.setName("Tony");
		e.setAdd("Avadi");
		
		rs.setStatus(200);
		rs.setMsg("Data fetch successfully");
		rs.setData(e);
		return rs;
	}

	
	@GetMapping("/cap")
	public ResponseEntity<String> msg2() {
	    return ResponseEntity.ok("Hello from Spring");
	}
	@GetMapping("/gemini")
	public ResponseEntity<String> msg3() {
	    return ResponseEntity.status(HttpStatus.CREATED).body("saved data successfully");
	}
	
	@PostMapping("/capgemini")
	public ResponseEntity<ResponseStructure<Employee>> save3() {
	    Employee e = new Employee(10,"Caitlyn","Chennai");
	    ResponseStructure<Employee> rs = new ResponseStructure<Employee>();
	    rs.setStatus(HttpStatus.OK.value());
	    rs.setMsg("Data Saved");
	    rs.setData(e);
	    return ResponseEntity.status(HttpStatus.OK).body(rs);
	}
	
}
