package com.Salary_MicroService.POJO;

//@Entity
//@Table(name="salary")
public class Salary {
	

//	@Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int salaryId;
	
//	@NotBlank
//	@Size(max = 20)
	private String Salary;

private int empId;
	
	public Salary() {}

	public Salary(int salaryId, String salary, int empId) {
		this.salaryId = salaryId;
		Salary = salary;
		this.empId = empId;
	}

	public int getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
}
