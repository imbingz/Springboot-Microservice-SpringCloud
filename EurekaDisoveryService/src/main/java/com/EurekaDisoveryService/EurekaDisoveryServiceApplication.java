package com.EurekaDisoveryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDisoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDisoveryServiceApplication.class, args);
		System.out.println("\n EurekaDisoveryServiceApplication RUNNING SUCCESSFULLY \n");
	}

}
