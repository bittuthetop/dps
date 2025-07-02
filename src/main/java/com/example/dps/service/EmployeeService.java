package com.example.dps.service;
import com.example.dps.entity.Employee;
import java.util.*;
public interface EmployeeService {
	
	public List<Employee> findAllEmployee();
	
	public void saveEmployee(Employee emp);
	
	
	

}
