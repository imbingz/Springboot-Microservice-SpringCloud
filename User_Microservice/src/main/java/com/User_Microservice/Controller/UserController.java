package com.User_Microservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.User_Microservice.Entity.AuthRequest;
import com.User_Microservice.Entity.ResponseRestTemplate;
import com.User_Microservice.Entity.Salary;
import com.User_Microservice.JwtUtil.JwtUtil;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@CircuitBreaker(name = "userServer", fallbackMethod = "fallbackForEmployeeService")
	@GetMapping("/")
	public ResponseEntity<?> getEmployee() {

		ResponseRestTemplate temp = restTemplate.getForObject("http://EMPLOYEE-SERVICE/emps",
				ResponseRestTemplate.class);
		return new ResponseEntity<>(temp, HttpStatus.OK);
	}

	@GetMapping("/salary")
	public ResponseEntity<?> getOnlyPrice() {

		Salary salary = restTemplate.getForObject("http://SALARY-SERVICE/salary", Salary.class);
		return new ResponseEntity<>(salary, HttpStatus.OK);
	}

	public ResponseEntity<?> fallbackForEmployeeService(Exception e) {
		return new ResponseEntity<>("Employee Service is down. Please try after some time", HttpStatus.OK);
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception e) {
			new Exception("Invalid USERNAME/PASSOWRD");
		}

		return jwtUtil.generateToken(authRequest.getUsername());
	}
}
