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
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public ClassRoom getClassRoom() {
		return classRoom;
	}
	

	

	@Column(name = "First_Name")
    private String FirstName;

    @Column(name = "Last_Name")
    private String LastName;

    @Column(name = "email")
    private String email;
    
    
    private String Password;

    @ManyToOne
    @JoinColumn(name = "class_name") //error
    private ClassRoom classRoom;

	public void setClassRoom(ClassRoom classRoom2) {
		// TODO Auto-generated method stub
		this.classRoom = classRoom2;
		
	}

    // Getters and Setters for all fields including classRoom
}
