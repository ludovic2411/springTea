package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dal.entities.Product;
import com.example.demo.services.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("")
	public ResponseEntity<List<Product>> getAll(){
		return new ResponseEntity <List<Product>>((List<Product>) service.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable("id") long id){
		return new ResponseEntity<Product>(service.GetById(id).get(),HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Product> create(@RequestBody Product entity){
		return new ResponseEntity<Product>(service.create(entity),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public boolean update(@PathVariable("id") long id,@RequestBody Product entity) throws Exception {
		return service.update(entity, id);
	}
	
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable("id") long id) {
		return service.delete(id);
	}
}
