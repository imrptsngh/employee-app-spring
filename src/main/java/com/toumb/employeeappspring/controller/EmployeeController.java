package com.toumb.employeeappspring.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.toumb.employeeappspring.entity.Employee;
import com.toumb.employeeappspring.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		// Get the employee list from the Service
		List<Employee> employees = employeeService.findAll();
		
		// Add the employee list to the model
		model.addAttribute("employees", employees);
		
		return "employees/list-employees";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		// Create model attribute to bind form data
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee, BindingResult result) throws IOException {
		// Add one day to the date stored to fix a MySQL bug
		java.sql.Date dateOfBirth = employee.getDateOfBirth();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateOfBirth);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		dateOfBirth = new Date(cal.getTimeInMillis());
		employee.setDateOfBirth(dateOfBirth);
		// Save the employee using the service
		employeeService.save(employee);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("employeeId") int id, Model model) {
		// Get employee from the service
		Employee employee = employeeService.findById(id);
		// Set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		// Send to the form		
		return "employees/employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		// Delete the employee record
		employeeService.deleteById(id);
		
		return "redirect:/employees/list";
	}
	
}
