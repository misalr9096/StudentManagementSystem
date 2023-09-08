package com.jspider.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspider.springmvc.pojo.AdminPOJO;
import com.jspider.springmvc.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService service;
	
	@GetMapping("/createnewaccount")
	public String createAccount(ModelMap map) {
		
		AdminPOJO pojo= service.getAdmin();
		
		if(pojo != null) {
			map.addAttribute("message", "Acccount Already Exits");
			return "Login";
		}
		return "CreateAccount";
	}
	
	@PostMapping("/createAccount")
	public String createAccount(@RequestParam String username,@RequestParam String password,ModelMap map){ 
		
		AdminPOJO pojo=service.createAccount(username,password);
		
		if(pojo != null) {
			map.addAttribute("message", "Acccount Created Sccuessfully..!");
			return "Login";
		}
		map.addAttribute("message", "Acccount Not Created ..!");
		return "Login";
		
	}

	@PostMapping("/login")
	public String login(@RequestParam String username,@RequestParam String password,ModelMap map) {
		
		AdminPOJO pojo=service.login(username,password);
		if(pojo != null) {
			return "Home";
		}
		map.addAttribute("message", "Invalid Credentials..!");
		return "Login";
	}
	
	@GetMapping("/login")
	public String login(ModelMap map) {
		map.addAttribute("message", "Logout Sccuessfully..!");
		return "Login";
	}

}
