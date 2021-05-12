package com.Salary_MicroService.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Salary_MicroService.POJO.Salary;

@RestController
@RequestMapping("/salary")
public class SalController {
	

	@GetMapping
	public ResponseEntity<?> getPriceOfProduct() {
		Salary salary = new Salary(1, "31000", 1);

		return new ResponseEntity<>(salary, HttpStatus.OK);
	}
	
	
//	
//	@Autowired
//	private SalServiceImpl service;
//	
//	@PostMapping("/save")
//	public Salary saveSal(@RequestBody Salary sal) {
//		System.out.println("Inside the saveSal method of Salary Controller");
//		return service.saveSal(sal);
//	}
//	
//	@GetMapping("/getSal")
//	public List<Salary> findSal(){
//		System.out.println("Inside the findSal method of Salary Controller");
//		return service.findSal();
//	}
//	
//	@GetMapping("/getSal/{salaryId}")
//	public Salary findSalById(@PathVariable Long salaryId){
//		System.out.println("Inside the findSalById method of Salary Controller");
//		return service.findSalById(salaryId);
//	}
}
