package com.example.dps.service;

import java.util.List;

import com.example.dps.entity.Student;
import com.example.dps.entity.ClassRoom;

public interface StudentService {

	public List<Student>  getAllStudents();
	public void saveUser(Student user);
	public Student findByEmail(String email);
	
	public Student addStudentToClass(int classId,Student student);
	

}
