package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dal.entities.Category;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping("")
	public ResponseEntity<List<Category>> getAll(){
		return new ResponseEntity<List<Category>>((List<Category>)service.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Category> findById(@PathVariable("id") long id) {
		return new ResponseEntity<Category>(service.GetById(id).get(),HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity <Category> create(@RequestBody Category c) {
		return ResponseEntity.ok(service.create(c));
	}
	
	@PutMapping("/{id}")
	public boolean update(@PathVariable("id") long id, @RequestBody Category c) throws Exception {
		return service.update(c, id);
	}
	
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable("id") long id) {
		return service.delete(id);
	}
}
