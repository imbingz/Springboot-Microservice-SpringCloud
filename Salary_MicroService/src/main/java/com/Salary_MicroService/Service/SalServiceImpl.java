//package com.Salary_MicroService.Service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.Salary_MicroService.DAO.SalaryRepo;
//import com.Salary_MicroService.POJO.Salary;
//
//@Service
//public class SalServiceImpl implements SalService {
//	
//	@Autowired 
//	private SalaryRepo salRepo;
//
//	@Override
//	public Salary saveSal(Salary sal) {
//		System.out.println("Inside the save Salary Method of Salary service");
//		return salRepo.save(sal);
//	}
//
//	@Override
//	public List<Salary> findSal() {
//		System.out.println("Inside the findSal Method of Salary service");
//		return salRepo.findAll();
//	}
//
//	@Override
//	public Salary findSalById(Long salaryId) {
//		System.out.println("Inside the findSalById Method of Salary service");
//		return salRepo.findSalById(salaryId);
//	}
//}
