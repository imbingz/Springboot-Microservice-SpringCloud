package com.User_Microservice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.User_Microservice.DAO.UserRepo;
import com.User_Microservice.Entity.User;

@SpringBootApplication
@EnableEurekaClient
public class UserMicroserviceApplication {

	@Autowired
	private UserRepo repository;

//	@PostConstruct
//	public void initUsers() {
//		List<User> user = Stream.of(new User(101, "abhishek", "admin", "abhi@gmail.com"),
//				new User(102, "kalpesh", "user", "kalpi@gmail.com"), new User(103, "user2", "pwd2", "user2@gmail.com"),
//				new User(104, "shweta", "user", "shweta@gmail.com")).collect(Collectors.toList());
//		repository.saveAll(user);
//	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedHeaders("*").allowedOrigins("http://localhost:8000")
//				.allowedMethods("*");
//			}
//		};
//	}


	@Bean
	@LoadBalanced
	public RestTemplate getRestTemple() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(UserMicroserviceApplication.class, args);
		System.out.println("\n UserMicroserviceApplication RUNNING SUCCESSFULLY");
	}
}
