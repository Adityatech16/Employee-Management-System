package com.gp.tech.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="address")

public class Address {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer addrId;
	private int HouseNo;
	private String landmark;
	private String city;
	private Integer pinCode;
	private String district;
	
	@OneToOne(mappedBy="addr")
	@JsonBackReference
	private Employee emp;

	public Integer getAddrId() {
		return addrId;
	}

	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}

	public int getHouseNo() {
		return HouseNo;
	}

	public void setHouseNo(int houseNo) {
		HouseNo = houseNo;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", HouseNo=" + HouseNo + ", ladndmark=" + landmark + ", city=" + city
				+ ", pinCode=" + pinCode + ", district=" + district + ", emp=" + emp + "]";
	}

	
	
}
