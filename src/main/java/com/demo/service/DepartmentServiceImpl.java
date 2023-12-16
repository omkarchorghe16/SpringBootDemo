package com.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.h2.Department;
import com.demo.h2.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
 
    @Autowired
    private DepartmentRepository departmentRepository;
 
    // Save operation
    @Override
    public Department saveDepartment(Department department)
    {
        return departmentRepository.save(department);
    }
 
    // Read operation
    @Override public List<Department> fetchDepartmentList()
    {
        return (List<Department>)
            departmentRepository.findAll();
    }
 
    // Update operation
    @Override
    public Department
    updateDepartment(Department department,
                     Long departmentId)
    {
        Department depDB
            = departmentRepository.findById(departmentId)
                  .get();
 
        if (Objects.nonNull(department.getDepartmentName())
            && !"".equalsIgnoreCase(
                department.getDepartmentName())) {
            depDB.setDepartmentName(
                department.getDepartmentName());
        }
 
        if (Objects.nonNull(
                department.getDepartmentAddress())
            && !"".equalsIgnoreCase(
                department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(
                department.getDepartmentAddress());
        }
 
        if (Objects.nonNull(department.getDepartmentCode())
            && !"".equalsIgnoreCase(
                department.getDepartmentCode())) {
            depDB.setDepartmentCode(
                department.getDepartmentCode());
        }
 
        return departmentRepository.save(depDB);
    }
 
    // Delete operation
    @Override
    public void deleteDepartmentById(Long departmentId)
    {
        departmentRepository.deleteById(departmentId);
    }

	@Override
	public Optional<Department> getDepartmentById(Long id) {
		Optional<Department> Department = departmentRepository.findById(id);
		return Department;
	}

	@Override
	public Department getDepartmentByName(String name) {
		//departmentRepository.findByName(name);
		return null;
	}
}
