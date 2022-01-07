
package com.zerodha.demo.entities;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class User {

	private String emailId;
	private String password;
	private String firstname;
	private String lastname;

	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public User( String emailId, String password, String firstname, String lastname) {
		super();
		//this.id = id;
		this.emailId = emailId;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", password=" + password + ", firstname=" + firstname + ", lastname="
				+ lastname + "]";
	}

	

}