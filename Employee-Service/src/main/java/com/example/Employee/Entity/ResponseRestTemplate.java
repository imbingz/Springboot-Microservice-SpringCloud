package com.example.Employee.Entity;

public class ResponseRestTemplate {
	
	private Employee employee;

	private Salary salary;
	
	public ResponseRestTemplate() {}

	
	public ResponseRestTemplate(Employee employee, Salary salary) {
		this.employee = employee;
		this.salary = salary;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "ResponseRestTemplate [employee=" + employee + ", salary=" + salary + "]";
	}
}
