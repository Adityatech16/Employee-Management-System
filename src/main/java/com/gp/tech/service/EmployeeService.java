package com.gp.tech.service;

import java.util.List;

import com.gp.tech.entity.Employee;

public interface EmployeeService {

	public Employee addEmp(Employee emp);
	
	public List<Employee> addAllEmployee(List<Employee> emps);
	
	public Employee getEmployee(Integer id);
	
	public List<Employee> getAllEmployees();
	
	public Employee updateEmp(Integer id,Employee emp);
	
	public String deleteEmployee(Integer id);
	
	
	
	
	
	
	
}
