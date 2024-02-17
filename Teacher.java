package com.jsp.jdbc_prepared_crud_with_architecture.entity;

import java.time.LocalDate;

public class Teacher {

	private int id;
	private String name;
	private String email;
	private LocalDate dob;
	
	public Teacher() {
		super();
	}

	public Teacher(int id, String name, String email, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + "]";
	}
	
}
