package com.example.Employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Entity.ResponseRestTemplate;
import com.example.Employee.Entity.Salary;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/emps")
@JsonSerialize
public class EmpController {
	
	
	@Autowired
	private RestTemplate restTemplate;

	@CircuitBreaker(name = "empServer", fallbackMethod = "fallbackForSalaryService")
	@GetMapping
	public ResponseEntity<?> getProduct() {

		Employee emp = new Employee(1, "AZX", "PE");

		Salary salary = restTemplate.getForObject("http://SALARY-SERVICE/salary", Salary.class);

		ResponseRestTemplate temp = new ResponseRestTemplate();

		temp.setEmployee(emp);
		temp.setSalary(salary);

		System.out.println(temp);
		return new ResponseEntity<>(temp, HttpStatus.OK);

	}

	public ResponseEntity<?> fallbackForSalaryService(Exception e) {
		return new ResponseEntity<>("Salary Service is down. Please try after some time", HttpStatus.OK);
	}
//	@Autowired
//	private EmpServiceImpl service;
//	
//	@Autowired
//	private RestTemplate restTemplate;
//
//	
//	@PostMapping("/save")
//	public Employee saveEmp(@RequestBody Employee emp) {
//		System.out.println("Inside the saveEmp method of Emp Controller");
//		return service.saveEmp(emp);
//	}
//	
//	@GetMapping("/getEmps")
//	public List<Employee> findEmp(){
//		System.out.println("Inside the findEmp method of Emp Controller");
//		return service.findEmp();
//	}
//	
//	@GetMapping("/getEmps/{empId}")
//	public Employee findEmpById(@PathVariable Long empId){
//		System.out.println("Inside the findEmpById method of Emp Controller");
//		return service.findEmpById(empId);
//	}
//
//	//@CircuitBreaker(name = "employeeServer", fallbackMethod = "fallbackForEmployeeService")
//	@GetMapping("/getEmpWithSalary/{empId}")
//	public ResponseRestTemplate getEmpWithSalary(@PathVariable Long empId) {
//		System.out.println("Inside the getEmpWithSalary method of Emp Controller");
//		return service.getEmpWithSalary(empId);
//	}
//	
//	public ResponseRestTemplate fallbackForEmployeeService(Exception e) {
//		System.out.println("Inside fallback for employee service. Emp Controller");
//		return new ResponseRestTemplate();
//	}
//	
//	@DeleteMapping("/{empId}")
//	public String deleteEmp(@PathVariable Long empId) {
//		System.out.println("Inside the deleteEmp method of Emp Controller");
//		return service.deleteEmp(empId);
//	}
		
}
