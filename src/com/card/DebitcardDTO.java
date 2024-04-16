package com.card;

import java.sql.Date;
import java.time.LocalDate;

public class DebitcardDTO {
	private int customerID;
	private String name;
	private int password;
	private LocalDate validFrom;
	private LocalDate validTo;
	private int cvv;
	private int initBalance;
	private long debitcardNumber;
	private Date validFromDB;
	private Date validToDB;
	
	
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
	public long getDebitcardNumber() {
		return debitcardNumber;
	}
	public void setDebitcardNumber(long debitcardNumber) {
		this.debitcardNumber = debitcardNumber;
	}
	public LocalDate getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(LocalDate validFrom) {
		this.validFrom = validFrom;
	}
	public LocalDate getValidTo() {
		return validTo;
	}
	public void setValidTo(LocalDate validTo) {
		this.validTo = validTo;
	}
	public Date getValidFromDB() {
		return validFromDB;
	}
	public void setValidFromDB(Date validFromDB) {
		this.validFromDB = validFromDB;
	}
	public Date getValidToDB() {
		return validToDB;
	}
	public void setValidToDB(Date validToDB) {
		this.validToDB = validToDB;
	}
}
