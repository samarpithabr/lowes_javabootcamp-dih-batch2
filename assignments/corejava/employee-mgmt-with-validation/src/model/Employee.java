package model;

import java.util.function.Predicate;

public class Employee {
int salary;
	int EmpId;
	String Name;
	int age;
	String designation;
	String department;
	String country;
	public Employee() {
		
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCountry() {
		return country;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Employee(int salary,int empId, String name, int age, String designation, String department, String country) {
	this.salary=salary;
		this.EmpId = empId;
		this.Name = name;
		this.age = age;
		this.designation = designation;
		this.department = department;
		this.country = country;
	}
	public String toString() {
		
	      return  "Salary"+salary+"\t" +
	    		  "Name "+Name+"\t"+
	    		  "Age "+ age+"\t"+
	    		  "Designation "+designation+"\t"+
	    		  "Department "+department+"\t"+
	    		  "Country "+country;
	    		  
	}
	
}
