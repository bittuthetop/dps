package com.example.dps.serviceimpl;

import com.example.dps.service.EmployeeService;
import com.example.dps.service.StudentService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dps.entity.ClassRoom;
import com.example.dps.entity.Student;
import com.example.dps.repository.EmployeeRepository;
import com.example.dps.entity.Employee;


@Service
public class Employeeimpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeerepository;
	
	@Override
	public List<Employee>findAllEmployee(){
		return employeerepository.findAll();
	}
	
	@Override
	public void saveEmployee(Employee emp) {
		
		employeerepository.save(emp);
	}
	
	
	
	
	
	
	
	
	

}
