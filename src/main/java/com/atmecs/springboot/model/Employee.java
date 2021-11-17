package com.atmecs.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * a pojo is generated for Employee class for values firstName,lastName,dept,salary
 * @Entity is used to define class as entity so that JPA is aware of it
 * @Table is used to specify name of the table i.e "employees"
 * @Id is used to define a primary key for the table
 * @GeneratedValue is used to generate primary key status strategy
 * @Column is used to provide column details(name,length,nullable,etc)
 * 
 *
 */


@Entity
@Table(name="employees")
public class Employee {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="first_name",nullable=false)
	private String firstName;
	
	@Column(name="last_name",nullable=false)
	private String lastName;
	
	@Column(name="dept",nullable=false)
	private String dept;
	
	@Column(name="salary",nullable=false)
	private int salary;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	

	

}
