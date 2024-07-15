package com.gp.tech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.tech.entity.Address;
import com.gp.tech.entity.Department;
import com.gp.tech.entity.Employee;
import com.gp.tech.repository.AddressRepository;
import com.gp.tech.repository.DepartmentRepository;
import com.gp.tech.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository emprepo;

	@Autowired
	private DepartmentRepository deptrepo;

	@Autowired
	private AddressRepository addrepo;

	@Override
	public Employee addEmp(Employee emp) {

		// Handling Department
		Department dept;
		if (emp.getDept().getDeptId() != null) {
			// Fetch existing department if it exists
			dept = deptrepo.findById(emp.getDept().getDeptId()).orElseGet(Department::new);
		} else {
			// Create a new department
			dept = new Department();
		}

		dept.setDeptName(emp.getDept().getDeptName());
		dept.setDesignation(emp.getDept().getDesignation());
		dept.setEmp(emp);

		// Save department
		dept = deptrepo.save(dept);

		// Handling Address
		Address add;
		if (emp.getAddr().getAddrId() != null) {
			// Fetch existing address if it exists
			add = addrepo.findById(emp.getAddr().getAddrId()).orElseGet(Address::new);
		} else {
			// Create a new address
			add = new Address();
		}

		add.setCity(emp.getAddr().getCity());
		add.setHouseNo(emp.getAddr().getHouseNo());
		add.setLandmark(emp.getAddr().getLandmark());

		add.setPinCode(emp.getAddr().getPinCode());
		add.setDistrict(emp.getAddr().getDistrict());
		add.setEmp(emp);

		// Save address
		add = addrepo.save(add);

		// Set the updated or new department and address to employee
		emp.setDept(dept);
		emp.setAddr(add);

		// Save employee
		Employee employee = emprepo.save(emp);

		return employee;
	}

	@Override
	public List<Employee> addAllEmployee(List<Employee> emps) {

		List<Employee> saveAll = emprepo.saveAll(emps);

		return saveAll;
	}

	@Override
	public Employee getEmployee(Integer id) {

		Employee emp = emprepo.findById(id).orElseThrow();

		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmp = emprepo.findAll();

		return allEmp;
	}

	@Override
	public Employee updateEmp(Integer id, Employee emp) {
		Optional<Employee> employee = emprepo.findById(id);
		Employee updatedEmp = null;

		if (employee.isPresent()) {
			Employee exitEmp = employee.get();
			exitEmp.setlName(emp.getlName());
			exitEmp.setEmail(emp.getEmail());
			exitEmp.setMoNo(emp.getMoNo());
			exitEmp.setSalary(emp.getSalary());
			exitEmp.setJoingDate(emp.getJoingDate());

			// Handling Address
			Address exitAddr = exitEmp.getAddr();
			if (exitAddr != null) {
				exitAddr.setHouseNo(emp.getAddr().getHouseNo());
				exitAddr.setLandmark(emp.getAddr().getLandmark());
				exitAddr.setCity(emp.getAddr().getCity());
				exitAddr.setPinCode(emp.getAddr().getPinCode());
				exitAddr.setDistrict(emp.getAddr().getDistrict());
				exitEmp.setAddr(exitAddr);
			} else {
				Address newAddr = new Address();
				newAddr.setHouseNo(emp.getAddr().getHouseNo());
				newAddr.setLandmark(emp.getAddr().getLandmark());
				newAddr.setCity(emp.getAddr().getCity());
				newAddr.setPinCode(emp.getAddr().getPinCode());
				newAddr.setDistrict(emp.getAddr().getDistrict());
				exitEmp.setAddr(newAddr);
			}

			// Handling Department
			Department exitDept = exitEmp.getDept();
			if (exitDept != null) {
				exitDept.setDeptName(emp.getDept().getDeptName());
				exitDept.setDesignation(emp.getDept().getDesignation());
				exitEmp.setDept(exitDept);
			} else {
				Department newDept = new Department();
				newDept.setDeptName(emp.getDept().getDeptName());
				newDept.setDesignation(emp.getDept().getDesignation());
				exitEmp.setDept(newDept);
			}

			// Save the updated employee back to the repository
			updatedEmp = emprepo.save(exitEmp);
		}

		return updatedEmp;
	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub

	}

}
