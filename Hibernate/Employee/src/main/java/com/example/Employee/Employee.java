package com.example.Employee;

import jakarta.persistence.*;

@Entity
public class Employee{
	@Id
	private int empid;
	private String empname;
	private String dept;
	private double salary;
	private String date;
	public void setid(int id) {
		this.empid=id;
	}
	public void setname(String name) {
		this.empname=name;
	}
	public void setdept(String dept) {
		this.dept=dept;
	}
	public void setsalary(double salary) {
		this.salary=salary;
	}
	public void setdate(String date) {
		this.date=date;
	}
	public int getId() {
		  return this.empid;
	  }
	public String getname() {
		  return this.empname;
	  }
	public String getdept() {
		  return this.dept;
	  }
	public double getsalary() {
		  return this.salary;
	  }
	public String getdate() {
		  return this.date;
	  }
}