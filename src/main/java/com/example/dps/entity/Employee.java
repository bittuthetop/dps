package com.example.dps.entity;
import jakarta.persistence.Entity;


import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name = "employee")
public class Employee {
    
	@Id
	@Column(name = "Employee_id")
	private String EmpId;
	
	@Column(name = "Employee_Name")
	private String EmpName;
	
	@Column(name = "Employee_Email")
	private String EmpEmail;
	
	@Column(name = "phone")
	private String Mob;

	public String getEmpId() {
		return EmpId;
	}

	public void setEmpId(String empId) {
		EmpId = empId;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public String getEmpEmail() {
		return EmpEmail;
	}

	public void setEmpEmail(String empEmail) {
		EmpEmail = empEmail;
	}

	public String getMob() {
		return Mob;
	}

	public void setMob(String mob) {
		Mob = mob;
	}
	
	
	

	

}
