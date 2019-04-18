package com.example.demo.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.example.demo.dal.entities.Product;

@Repository
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	 <S extends Product> S save(S entity);

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void deleteById(Long id);

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void delete(Product entity);
}
