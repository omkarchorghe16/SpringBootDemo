package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.h2.Department;
import com.demo.service.DepartmentService;

@RestController
@RequestMapping("/department") 
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/addDepartment")
	public Department addDepartment(@RequestBody Department Department) {
		return departmentService.saveDepartment(Department);
	}

	
	@GetMapping("/departments")
	public List<Department> findAllDepartments() {
		/*
		List<Department> Departments=new ArrayList<>();
		Department p1 = new Department();
		p1.setName("Pen");
		p1.setQuantity(1);
		p1.setPrice(10);
		Departments.add(p1);
		service.saveDepartments(Departments);
		*/
		return departmentService.fetchDepartmentList();
	}

	@GetMapping("/departmentById/{id}")
	public Optional<Department> findDepartmentById(@PathVariable Long id) {
		return departmentService.getDepartmentById(id);
	}

	@GetMapping("/departmentByName/{name}")
	public Department findDepartmentByName(@PathVariable String name) {
		return departmentService.getDepartmentByName(name);
	}

	@PutMapping("/update")
	public Department updateDepartment(@RequestBody Department Department) {
		return departmentService.updateDepartment(Department,Department.getDepartmentId());
	}

	@DeleteMapping("/delete/{id}")
	public void deleteDepartment(@PathVariable Long id) {
		departmentService.deleteDepartmentById(id);
	}
}
