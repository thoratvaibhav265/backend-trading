package com.zerodha.demo.entities;

import java.time.LocalDate;
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
@Table(name = "trader")
public class Trader extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long traderId;
	
	private LocalDate dateOfBirth;

	private String phoneNumber;

	private String panNumber;



	@OneToMany(mappedBy = "trader",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<Shares> shares;

	public Long getTraderId() {
		return traderId;
	}

	public void setTraderId(Long traderId) {
		this.traderId = traderId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}



	public List<Shares> getShares() {
		return shares;
	}

	public void setShares(List<Shares> shares) {
		this.shares = shares;
	}

	public Trader(String emailId, String password, String firstname, String lastname, Long traderId,
			LocalDate dateOfBirth, String phoneNumber, String panNumber, List<Shares> shares) {
		super(emailId, password, firstname, lastname);
		this.traderId = traderId;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.panNumber = panNumber;
		this.shares = shares;
	}

	public Trader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trader(String emailId, String password, String firstname, String lastname) {
		super(emailId, password, firstname, lastname);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Trader [traderId=" + traderId + ", dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber
				+ ", panNumber=" + panNumber + ",  shares=" + shares + "]";
	}

	
}
