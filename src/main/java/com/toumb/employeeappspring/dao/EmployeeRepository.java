package com.toumb.employeeappspring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toumb.employeeappspring.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// Add a method to sort records by last name
	public List<Employee> findAllByOrderByLastNameAsc();

}
