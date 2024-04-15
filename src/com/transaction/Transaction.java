package com.transaction;

import java.util.Scanner;

public abstract class Transaction {
	
	public int payAmount() {
		Scanner paySnr = new Scanner(System.in);
		System.out.println("Enter the amount to credit");
		int amount = paySnr.nextInt();
		return amount;
	}
	
	public int getAmount() {
		Scanner getSnr = new Scanner(System.in);
		System.out.println("Enter the amount to debit");
		int amount = getSnr.nextInt();
		return amount;
	}
	
}
