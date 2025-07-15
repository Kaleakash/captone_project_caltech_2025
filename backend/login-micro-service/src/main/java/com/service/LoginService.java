package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Login;
import com.repository.LoginRepository;


@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	public String signIn(Login login) {		// emailid, password and typeofuser

			Optional<Login> result=	loginRepository.findById(login.getEmailid());
			if(result.isPresent()) {
					Login loginDbRef = result.get();		// hold emailid, password and typeof user from db.
					
					StringBuffer sb = new StringBuffer(login.getPassword());
					sb.reverse();
					login.setPassword(sb.toString());
					
					if(loginDbRef.getPassword().equals(login.getPassword())) {
							
					if(loginDbRef.getTypeofuser().equals(login.getTypeofuser()) && login.getTypeofuser().equals("admin")) {
						return "Admin login successfully";
					}else if(loginDbRef.getTypeofuser().equals(login.getTypeofuser()) && login.getTypeofuser().equals("customer")){
						return "Customer login successfully";
					}else {
						return "Not a valid type of user";
					}
							
						}else {
							return "Password is wrong";
						}
			
			}else {
				return "Emailid is not present";
			}

	}
	
	public String signUp(Login login) {
		
			if(loginRepository.existsById(login.getEmailid())) {
				return "Email id must be unique";
			}else {
				if(login.getTypeofuser().equals("admin")) {
					return "You can't create the admin account";
				}else {
					StringBuffer sb = new StringBuffer(login.getPassword());
					sb.reverse();
					login.setPassword(sb.toString());
					loginRepository.save(login);
					return "Account created successfully";
				}
				
			}
	}
	
	public String changePassword(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
			Login loginFromDb = result.get();
					if(loginFromDb.getPassword().equals(login.getPassword())) {
						
						if(login.getPassword().equals(login.getChangePassword())) {
							return "New password not equal to old password";
						}else {
							loginFromDb.setPassword(login.getChangePassword());
							loginRepository.saveAndFlush(loginFromDb);
							return "Your password changed successfully";
						}
						
					}else {
						return "Password is wrong";
					}
		}else {
			return "Emailid not exists";
		}
	}
}
