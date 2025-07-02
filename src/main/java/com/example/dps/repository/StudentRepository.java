package com.example.dps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dps.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

	Student findByEmail(String email);
	






}
 