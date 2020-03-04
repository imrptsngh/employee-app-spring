package com.toumb.employeeappspring.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.toumb.employeeappspring.entity.Employee;

@Controller
@RequestMapping("/employee")
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
		
		return "list-employees";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		// Create model attribute to bind form data
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// Save the employee using the service
		employeeService.save(employee);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("employeeId") int id, Model model) {
		// Get employee from the service
		Employee employee = employeeService.findById(id);
		// Set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		// Send to the form		
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		// Delete the code record
		employeeService.deleteById(id);
		
		return "redirect:/employee/list";
	}
	
}
