package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.entity")
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "com.repository")
public class ProductMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMicroServiceApplication.class, args);
		System.out.println("product micro service up on port number 9191");
	}

}
