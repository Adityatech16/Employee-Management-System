package com.gp.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gp.tech.entity.Employee;
import com.gp.tech.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empservice;

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {

		Employee addEmp = empservice.addEmp(emp);

		return new ResponseEntity<>(addEmp, HttpStatus.CREATED);

	}

	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {

		Employee employee = empservice.getEmployee(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);

	}

}
