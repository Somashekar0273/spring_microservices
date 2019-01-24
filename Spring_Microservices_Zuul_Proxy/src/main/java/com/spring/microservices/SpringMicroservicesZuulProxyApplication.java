package com.spring.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SpringMicroservicesZuulProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesZuulProxyApplication.class, args);
	}

}

