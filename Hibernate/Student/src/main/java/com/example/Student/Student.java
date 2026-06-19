package com.example.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student{
	@Id
	private int studentId;
	private String studentName;
	private String email;
	private String course;
	private int age;
	
  public void setstudentId(int studentId) {
	  this.studentId=studentId;
  }
  public void setstudentName(String studentName) {
	  this.studentName=studentName;
  }
  public void setemail(String email) {
	  this.email=email;
  }
  public void setcourse(String course) {
	  this.course=course;
  }
  public void setage(int age) {
	  this.age=age;
  }
  public int getId() {
	  return this.studentId;
  }
  public String getName() {
	  return this.studentName;
  }
  public String getemail() {
	  return this.email;
  }
  public String getcourse() {
	  return this.course;
  }
  public int getage() {
	  return this.age;
  }
}