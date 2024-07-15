package com.gp.tech.entity;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="EmployeeDetails")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String lName;
	private String MoNo;
	private Double salary;
	private String email;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date joingDate;
	
	@OneToOne
	@JsonManagedReference
	private Department dept;
	
	@OneToOne
	@JsonManagedReference
	private Address addr;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getMoNo() {
		return MoNo;
	}
	public void setMoNo(String moNo) {
		MoNo = moNo;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJoingDate() {
		return joingDate;
	}
	public void setJoingDate(Date joingDate) {
		this.joingDate = joingDate;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", lName=" + lName + ", MoNo=" + MoNo + ", salary=" + salary
				+ ", email=" + email + ", joingDate=" + joingDate + ", dept=" + dept + ", addr=" + addr + "]";
	}
	
	
	
	
	
	
}
