package com.example.dps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dps.entity.ClassRoom;
import com.example.dps.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends  JpaRepository<Employee, String> {


	
	

}
