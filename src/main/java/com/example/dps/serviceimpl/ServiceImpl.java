package com.example.dps.serviceimpl;

import com.example.dps.service.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dps.entity.ClassRoom;
import com.example.dps.entity.Student;
import com.example.dps.repository.ClassRoomRepository;
import com.example.dps.repository.StudentRepository;

@Service
public class ServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveUser(Student user) {
        studentRepository.save(user);
    }

    @Override
    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    
    public Student addStudentToClass(int classId, Student student) {
        ClassRoom classRoom = classRoomRepository.findById(classId).orElseThrow(() -> new RuntimeException("Class not found"));
        student.setClassRoom(classRoom);
        return studentRepository.save(student);
    }
}
