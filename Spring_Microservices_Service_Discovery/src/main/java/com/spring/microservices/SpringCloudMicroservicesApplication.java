package com.spring.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudMicroservicesApplication.class, args);
	}

}

