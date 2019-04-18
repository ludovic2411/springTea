package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dal.entities.Product;
import com.example.demo.dal.repositories.ProductRepository;

@Service
public class ProductService implements CrudService<Product, Long> {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public Iterable<Product> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Product> GetById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Product create(Product entity) {
		
		return repo.save(entity);
	}

	@Override
	public boolean update(Product entity, Long id) throws Exception {
		Product p=repo.findById(id).orElseThrow(()->new Exception("No product found"));
		p.setImageUrl(entity.getImageUrl());
		p.setName(entity.getName());
		p.setCategory(entity.getCategory());
		p.setPrice(entity.getPrice());
		p.setQuantity(entity.getQuantity());
		return repo.save(p)!=null ;
	}

	@Override
	public boolean delete(Long id) {
		repo.deleteById(id);
		return repo.existsById(id);
	}


}
