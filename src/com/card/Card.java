package com.card;

import java.util.Scanner;
import java.sql.Date;
import java.time.LocalDate;

public class Card {
	private int initBalance = 0;
	private String cardName = null;
	private int cvv = 0;
	private long cardNumber = 0;
	private String nameOnCard = null;
	private LocalDate validFrom = null;
	private LocalDate validUpto = null;


	public String getCardName() {
		return cardName;
	}


	public void setCardName(String cardName) {
		this.cardName = cardName;
	}


	public int getCvv() {
		return cvv;
	}


	public void setCvv(int cvv) {
		this.cvv = cvv;
	}


	public long getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getNameOnCard() {
		return nameOnCard;
	}


	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}


	public LocalDate getValidFrom() {
		return validFrom;
	}


	public void setValidFrom(LocalDate validFrom) {
		this.validFrom = validFrom;
	}


	public LocalDate getValidUpto() {
		return validUpto;
	}


	public void setValidUpto(LocalDate validUpto) {
		this.validUpto = validUpto;
	}


	public int getInitBalance() {
		return initBalance;
	}


	public void setInitBalance(int initBalance) {
		this.initBalance = initBalance;
	}
	
}
