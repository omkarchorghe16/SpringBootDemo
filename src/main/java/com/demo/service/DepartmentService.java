package com.demo.service;

//Importing required classes
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.entity.h2.Department;

@Service
public interface DepartmentService {

	 // Save operation
    Department saveDepartment(Department department);
 
    // Read operation
    List<Department> fetchDepartmentList();
 
    // Update operation
    Department updateDepartment(Department department,
                                Long departmentId);
 
    // Delete operation
    void deleteDepartmentById(Long departmentId);

	Optional<Department> getDepartmentById(Long id);

	Department getDepartmentByName(String name);
    
    
}
