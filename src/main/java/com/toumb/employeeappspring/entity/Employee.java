package com.toumb.employeeappspring.entity;

import java.sql.Date;

public class Employee {
	private int id;
	private String title;
	private String firstName;
	private String lastName;
	private String jobTitle;
	private String department;
	private String email;
	private String phone;
	private Date dateOfBirth;
	private String address;
	private String notes;
	
	public Employee(int id, String title, String firstName, String lastName, String jobTitle, String department,
			String email, String phone, Date dateOfBirth, String address, String notes) {
		this.id = id;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobTitle = jobTitle;
		this.department = department;
		this.email = email;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.notes = notes;
	}
	
	public Employee(String title, String firstName, String lastName, String jobTitle, String department,
			String email, String phone, Date dateOfBirth, String address, String notes) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobTitle = jobTitle;
		this.department = department;
		this.email = email;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.notes = notes;
	}
	
	public Employee() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", jobTitle=" + jobTitle + ", department=" + department + ", email=" + email + ", phone=" + phone
				+ ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", notes=" + notes + "]";
	}
	
}
