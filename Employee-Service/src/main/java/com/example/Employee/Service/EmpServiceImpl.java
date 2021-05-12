//package com.example.Employee.Service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.example.Employee.DAORepo.EmpRepo;
//import com.example.Employee.Entity.Employee;
//import com.example.Employee.Entity.ResponseRestTemplate;
//import com.example.Employee.Entity.Salary;
//
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//
//@Service
//public class EmpServiceImpl implements EmpService {
//
//	@Autowired 
//	private EmpRepo empRepo;
//	
//	@Autowired
//	@LoadBalanced
//	private RestTemplate restTemplate; //make http calls for Salary service
//
//	
//	@Override
//	public Employee saveEmp(Employee emp) {
//		System.out.println("Inside the saveEmp Method of Emp service");
//		return empRepo.save(emp);
//	}
//
//	@Override
//	public List<Employee> findEmp() {
//		System.out.println("Inside the findEmp Method of Emp service");
//		return empRepo.findAll();
//	}
//
//	@Override
//	public Employee findEmpById(Long empId) {
//		System.out.println("Inside the findEmpById Method of Emp service");
//		return empRepo.findByEmpId(empId);
//	}
//	
//	@Override
//	//@CircuitBreaker(name = "employeeService", fallbackMethod = "fallbackForEmployeeService")
//	public ResponseRestTemplate getEmpWithSalary(Long empId) {
//		System.out.println("Inside the getEmpWithSalary Method of Emp service");
//		ResponseRestTemplate vo = new ResponseRestTemplate();
//		Employee employee = empRepo.findByEmpId(empId);
//		
//		Salary salary = restTemplate
//				.getForObject("http://SALARY-SERVICE/salary/getSal/" + employee.getSalaryId(), Salary.class);
//		
//		vo.setEmployee(employee);
//		vo.setSalary(salary);
//		
//		return vo;
//	}
//	
//	public ResponseRestTemplate fallbackForEmployeeService(Long empId, Throwable t) {
//		System.out.println("Inside fallback for employee service. Error: " + t);
//		return new ResponseRestTemplate();
//	}
//
//	@Override
//	public String deleteEmp(Long empId) {
//		System.out.println("Inside the deleteEmp Method of Emp service");
//		empRepo.deleteByEmpId(empId);
//		String message="Record deleted successfully";
//		return message;
//	}
//	
//}
