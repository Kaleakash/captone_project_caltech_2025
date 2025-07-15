package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Login;
import com.service.LoginService;

@RestController
@RequestMapping("login")		// http://localhost:9090/login/*
@CrossOrigin
public class LoginController {

	@Autowired
	LoginService loginService;
	
	// http://localhost:9090/login/signIn
	// method : post 
	// data : {"emailid":"steven@gmail.com","password":"steven@123","typeofuser":"customer"}
	
	@PostMapping(value = "signIn",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody Login login) {
		return loginService.signIn(login);
	}

	
	// http://localhost:9090/login/signUp
	// method : post 
	// data : {"emailid":"steven@gmail.com","password":"steven@123","typeofuser":"customer"}

	@PostMapping(value = "signUp",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signUp(@RequestBody Login login) {
		return loginService.signUp(login);
	}
	
	// http://localhost:9090/login/changePassword
		// method : put
		// data : {"emailid":"steven@gmail.com","password":"steven@123","changePassword":"steven@1234"}
	
	@PutMapping(value="changePassword",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String changePassword(@RequestBody Login login) {
		
		return loginService.changePassword(login);
	}
}
