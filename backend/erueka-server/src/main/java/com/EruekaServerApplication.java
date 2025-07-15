package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EruekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EruekaServerApplication.class, args);
		System.out.println("Eureka Server up on port number 8761");
	}

}
