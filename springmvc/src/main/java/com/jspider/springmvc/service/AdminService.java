package com.jspider.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jspider.springmvc.pojo.AdminPOJO;
import com.jspider.springmvc.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired 
	AdminRepository repository;
	
	
	public AdminPOJO getAdmin() {
		return  repository.getAdmin();
	}


	public AdminPOJO createAccount(String username, String password) {
		// TODO Auto-generated method stub
		return repository.createAccount(username,password);
	}


	public AdminPOJO login(String username, String password) {
		
		return repository.login(username,password);
	}
	
}
