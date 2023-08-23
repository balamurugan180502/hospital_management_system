package com.h.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.h.model.AdminLogin;
import com.h.service.AdminRegisterService;


@CrossOrigin(origins = "http://localhost:4200")//enable cross-origin resource sharing only for this specfic method
@RestController// making restful web service
@RequestMapping("/api/admin")//indicates that spring should deserialize a request body into an object
public class AdminController {
	
	@Autowired// it is used for automatic dependency injection =>
				//dependency injection is a fundamental aspect of the spring framework through which the spring contains
				
	AdminRegisterService aservice;
	
	@PostMapping("/register")
	public AdminLogin reg(@RequestBody AdminLogin ar) {
		return aservice.register(ar);
		
	}
	
	@PostMapping("/login")
	public AdminLogin log(@RequestBody AdminLogin ar) {
		return aservice.login(ar);
		
	}
	
	@GetMapping("/listByName/{email}")
	public AdminLogin listByname(@PathVariable String email){
		return aservice.listByName(email);
		
	}

}
