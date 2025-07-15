package com;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.entity.Login;
import com.repository.LoginRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = "com") // Enable @RestController, @Service, @Repository 
@EntityScan(basePackages = "com.entity")			// Enable @Entity annotation 
@EnableJpaRepositories(basePackages = "com.repository")  // enable repository features
@EnableDiscoveryClient								// deploy this project on Eureka server 
public class LoginMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginMicroServiceApplication.class, args);
		System.out.println("Login micro service up on port number 9090");
	}
	
	
	@Autowired
	LoginRepository loginRepository;
	
	@PostConstruct
	public void init() {
		System.out.println("this method called..");
		Login ll = new Login();
		ll.setEmailid("admin@gmail.com");
		ll.setPassword("admin@123");
		ll.setTypeofuser("admin");
		
		StringBuffer sb = new StringBuffer(ll.getPassword());		// actual password is admin@123 
		sb.reverse();											// 321@nimda
		ll.setPassword(sb.toString());
		Optional<Login> result = loginRepository.findById(ll.getEmailid());
		if(result.isPresent()) {
			System.out.println("Admin account present");
		}else {
			loginRepository.save(ll);
			System.out.println("Admin account created..");
		}
		
	}

}
