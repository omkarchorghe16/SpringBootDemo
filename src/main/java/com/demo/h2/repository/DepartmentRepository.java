package com.demo.h2.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.h2.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

	//Department findByName(String name);
	
	Optional<Department> findById(Long id);

	
}
