package com.Salary_MicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableEurekaClient
public class SalaryMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalaryMicroServiceApplication.class, args);
		System.out.println("\n SalaryMicroServiceApplication RUNNING SUCCESSFULLY");
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedHeaders("*").allowedOrigins("http://localhost:8082")
						.allowedMethods("*");
			}
		};
	}
}
