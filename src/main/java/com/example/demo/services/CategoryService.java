package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dal.entities.Category;
import com.example.demo.dal.repositories.CategoryRepository;

@Service
public class CategoryService implements CrudService<Category,Long> {
	
	@Autowired
	private CategoryRepository repo;

	@Override
	public Iterable<Category> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional <Category> GetById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Category create(Category entity) {
		// TODO Auto-generated method stub
		return repo.save(entity);
	}

	@Override
	public boolean update(Category entity, Long id) throws Exception {
		Category c=repo.findById(id).orElseThrow(()->new Exception ("category not found"));
		c.setName(entity.getName());
		return repo.save(c)!=null;
	}

	@Override
	public boolean delete(Long  id) {
		repo.deleteById(id);
		return repo.existsById(id);
	}
}
