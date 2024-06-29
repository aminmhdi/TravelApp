package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com")
@EnableDiscoveryClient
public class CabApplication {
	public static void main(String[] args) {
		SpringApplication.run(CabApplication.class, args);
		System.err.println("Cabs is up");
	}
}
