package com.toumb.employeeappspring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.toumb.employeeappspring.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// Add a method to sort records by last name
	public List<Employee> findAllByOrderByLastNameAsc();
	
	// Add a method to search records with keyword
	@Query("FROM Employee WHERE LOWER(first_name) LIKE ?1 OR LOWER(last_name) LIKE ?1"
	       + " OR LOWER(job_title) LIKE ?1 OR LOWER(department) LIKE ?1 OR LOWER(email) LIKE ?1")
	public List<Employee> findByKeyword(String keyword);

}
