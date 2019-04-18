package com.example.demo.services;

import java.util.Optional;

public interface CrudService<TENTITY,ID> {
	Iterable<TENTITY> findAll();
	Optional<TENTITY> GetById(ID id);
	TENTITY create(TENTITY entity);
	boolean update(TENTITY entity,ID id) throws Exception;
	boolean delete(ID id);
}
