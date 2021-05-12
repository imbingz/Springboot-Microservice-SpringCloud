package com.example.Employee.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="employee")
public class Employee{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	
	@NotBlank
	@Size(max = 20)
	private String empName;
	
	@NotBlank
	@Size(max = 20)
	private String empDesignation;
	
	
	public Employee() {}


	public Employee(int empId, @NotBlank @Size(max = 20) String empName,
			@NotBlank @Size(max = 20) String empDesignation) {
		this.empId = empId;
		this.empName = empName;
		this.empDesignation = empDesignation;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmpDesignation() {
		return empDesignation;
	}


	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

}
