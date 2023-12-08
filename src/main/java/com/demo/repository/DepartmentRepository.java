package com.demo.repository;

import org.springframework.stereotype.Repository;

import com.demo.entity.h2.Department;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
