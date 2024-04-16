package com.transaction;

import java.util.Scanner;

public class Transaction {
	private int amount = 0;
	private transactionType transType;
	enum transactionType{
		creditAmount,
		debitAmount
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public transactionType getTransType() {
		return transType;
	}

	public void setTransType(transactionType transType) {
		this.transType = transType;
	}

}
