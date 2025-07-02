
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.PutMapping;
////import org.springframework.web.bind.annotation.DeleteMapping;
//
//import org.springframework.stereotype.Controller;
//
//
//
//@Controller
//public class Controller {
//
//	@GetMapping("/home")
//	public String home() {
//		return home;
//	}
//	
//
//}

package com.example.dps.controller;


import com.example.dps.repository.ClassRoomRepository;
import com.example.dps.repository.EmployeeRepository;
import com.example.dps.service.EmployeeService;
import com.example.dps.service.StudentService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dps.entity.*;
import com.example.dps.repository.ClassRoomRepository;
import com.example.dps.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
@Controller
public class MyController {
   
	@Autowired
	
   private StudentService studentService;
	

  @Autowired
   private ClassRoomRepository classRoomRepository;
  
  @Autowired 
  private EmployeeService employeeService;
  
  

    @GetMapping("/home")
    public String home() {
        return "home"; 
    }
    
    @GetMapping("/students")
    public String getAllStudents(Model model) {
    	model.addAttribute("students",studentService.getAllStudents());
    	return "students";
    }
    @GetMapping("students/new")
    public String createStudentForm(Model model) {
    	
    	Student student = new Student();
    	model.addAttribute("students", student);
    	return "create-student";
    }
    @GetMapping("signin")
    public String signUpform() {
    	
    	return "SignUpForm";
    }
    
    @PostMapping("/submit_registration")
    public String registerUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password) {
    	Student stu = new Student();
    	stu.setFirstName(firstName);
    	stu.setLastName(lastName);
    	stu.setEmail(email);
    	stu.setPassword(password);
    	studentService.saveUser(stu);
    	return "login";
    }
    
    @PostMapping("/login")
    public String LoginUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password) {
    	  Student stu = studentService.findByEmail(email);
    	  if(stu != null && stu.getPassword().equals(password)) {
    		  System.out.println("yes is matchedd");
    		  return "success";
    	  }
    	  System.out.println("nooo");
    	 
    		  return "login";
    	  
    	  
    	
    }
    
   
    @GetMapping("/classrooms/add")
    public String addClassRoom() {
    	 
    	return "ClassRoomAdd";
    }
    
    @GetMapping("/students/add")
    public String addStudent() {
    	return "addStudent";
    }
    
    @PostMapping("/classrooms/add")
    public String addClassRoom(@RequestParam String className) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setClassName(className);
        
		classRoomRepository.save(classRoom);
        return "success";
    }

    @PostMapping("/students/add")
    public String addStudent(@RequestParam String firstName,
                             @RequestParam String email,
                             @RequestParam String password,
                             @RequestParam int classId,Model model) {
        Student student = new Student();
        student.setFirstName(firstName);
      
        student.setEmail(email);
        student.setPassword(password);
        studentService.addStudentToClass(classId, student);
        
        


 



ClassRoom classRoom = classRoomRepository.findById(classId).orElse(null);
  if (classRoom == null) {
	  ClassRoom classRoom1 = new ClassRoom();
      classRoom1.setId(classId);
      
		classRoomRepository.save(classRoom1);
	  
//    model.addAttribute("error", "Class with ID " + classId + " not found.");
//     return "error"; // Create an error.html page to show this message
 }
  

  
  List<Student> students = classRoom.getStudents();


    model.addAttribute("className", classRoom.getClassName());
    model.addAttribute("students", students);


        return "Student_of_class";
    }
    
    @GetMapping("/get/student/{id}")
    public String TotalStudent(@PathVariable int id,Model model) {
    	ClassRoom classRoom = classRoomRepository.findById(id).orElse(null);
    	if(classRoom == null) {
    		
    		return "success";
    	}
    	
    		List<Student> students = classRoom.getStudents();


    	    model.addAttribute("className", classRoom.getClassName());
    	    model.addAttribute("students", students);


    	        return "Student_of_class";
    	
    }
    
	
    
    @GetMapping("/addEmployee")
    public String addEmployee() {
    	return "addEmployee";
    }
    
    @PostMapping("/addEmployee")
    public String addEmployeeTodatabase(@RequestParam String empid,@RequestParam String name,
    		@RequestParam  String email,@RequestParam String phone) {
    	
    	Employee emp = new Employee();
    	
    	emp.setEmpId(empid);
    	emp.setEmpEmail(email);
    	emp.setEmpName(name);
    	emp.setMob(phone);
    	
    	
    	employeeService.saveEmployee(emp);
    	
    	
    	
    	return "success";
    	
    }
    @GetMapping("/seeEmployee")
    public String seeAllEmployee(Model model) {
    	List<Employee> employees = employeeService.findAllEmployee();
    	model.addAttribute("employees",employees);
    	return "seeallemployees";
    }
    
    
    
    
    
    
    
    
         
    
}
