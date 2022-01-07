package com.zerodha.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Admin_table")
public class Admin extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adminId;

	@JsonIgnore
	@OneToMany(mappedBy = "admin", fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	private List<Shares> shares;

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public List<Shares> getShares() {
		return shares;
	}

	public void setShares(List<Shares> shares) {
		this.shares = shares;
	}

	public Admin(String emailId, String password, String firstname, String lastname, long adminId,
			List<Shares> shares) {
		super(emailId, password, firstname, lastname);
		this.adminId = adminId;
		this.shares = shares;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String emailId, String password, String firstname, String lastname) {
		super(emailId, password, firstname, lastname);
		// TODO Auto-generated constructor stub
	}

}
