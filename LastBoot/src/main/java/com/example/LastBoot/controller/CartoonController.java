package com.example.LastBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.LastBoot.dao.CartoonRepository;
import com.example.LastBoot.entity.Cartoon;

@RestController
public class CartoonController {
	@Autowired
	private CartoonRepository cartoonReposistory;
	
	@PostMapping("/save")
	public String saveCartoon(@RequestBody Cartoon cartoon) {
		cartoonReposistory.save(cartoon);
		return "save data successfully";
		
	}
	
	@PostMapping("/saveall")
	public String saveCartoonBatch(@RequestBody List<Cartoon> cartoon) {
		List<Cartoon> c=cartoonReposistory.saveAll(cartoon);
		return "saved successfully";
	}
	
	
	@GetMapping("/find/{id}")
	public Cartoon getById(@PathVariable Integer id) {
		return cartoonReposistory.findById(id).orElse(null);
		}
	
	@GetMapping("/fetchall")
	public List<Cartoon> getAll() {
		List<Cartoon> cartoon=cartoonReposistory.findAll();
		return cartoon;
	}
	
	
	@PutMapping("/update")
	public Cartoon update(@RequestBody Cartoon c) {
		
		return cartoonReposistory.save(c);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteRecord(@PathVariable Integer id) {
		if(cartoonReposistory.existsById(id)) {
			cartoonReposistory.deleteById(id);
			return "deleted successfully";
		}
		else {
			return "Record not found";
		}
	}
}
