package com.zerodha.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shares")
public class Shares {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String sharename;

	private double price;

	private int quantity;

	private String status;

	@ManyToOne
	@JoinColumn(name = "traderId")
	private Trader trader;

	@ManyToOne
	@JoinColumn(name = "adminId")
	private Admin admin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSharename() {
		return sharename;
	}

	public void setSharename(String sharename) {
		this.sharename = sharename;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Shares(Long id, String sharename, double price, int quantity, String status, Trader trader, Admin admin) {
		super();
		this.id = id;
		this.sharename = sharename;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
		this.trader = trader;
		this.admin = admin;
	}

	public Shares() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shares(int i, String sharename2, int price2, int quantity2, String status2, Trader trader2, Admin admin2) {
		// TODO Auto-generated constructor stub
	}
    
}
