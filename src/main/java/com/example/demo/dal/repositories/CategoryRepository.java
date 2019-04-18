package com.example.demo.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.example.demo.dal.entities.Category;

@Repository
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	<S extends Category> S save(S entity);

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	 void deleteById(Long id);

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void delete(Category entity);
	
	
	
}
