package com.toumb.employeeappspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

	@GetMapping("/login")
	public String showLoginPage() {
			
		return "login";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
			
		return "access-denied";
	}
	
}