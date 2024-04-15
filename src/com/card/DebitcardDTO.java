package com.card;

import java.time.LocalDate;

public class DebitcardDTO {
	private int customerID;
	private String name;
	private int password;
	private LocalDate expirydate;
	private int cvv;
	private int initBalance;
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public LocalDate getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(LocalDate expirydate) {
		this.expirydate = expirydate;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public int getInitBalance() {
		return initBalance;
	}
	public void setInitBalance(int initBalance) {
		this.initBalance = initBalance;
	}
}
