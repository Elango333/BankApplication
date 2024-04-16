package com.transaction;

import java.util.Scanner;

public class Transaction {
	private int debitAmount = 0;
	private int creditAmount = 0;
	
	public int getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(int debitAmount) {
		this.debitAmount = debitAmount;
	}

	public int getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(int creditAmount) {
		this.creditAmount = creditAmount;
	}
	
	public  int creditAmount() {
		Scanner paySnr = new Scanner(System.in);
		System.out.println("Enter the amount to credit");
		int amount = paySnr.nextInt();
		if((amount >= 100) && ((amount%100)==0) && (amount <= 10000)) {
			setCreditAmount(amount);
			System.out.println("\nCash details:");
			int fiveHundreds = amount / 500;
	        int remaining = amount % 500;
	        int twoHundreds = remaining / 200;
	        remaining %= 200;
	        int hundreds = remaining / 100;
	        System.out.println("Number of 500s : " + fiveHundreds);
	        System.out.println("Number of 200s : " + twoHundreds);
	        System.out.println("Number of 100s : " + hundreds);
		}
		else {
			  System.out.println("\n╔═══════════════════════════════════════════════════╗\n" +
					  			   "║       	        Note⚠️         		    ║\n" +
					  			   "║ >Amount should be greater than 100                ║\n" +
					  			   "║ >Amount should be multiple of 100                 ║\n" +
					  			   "║ (Ex. 500, 800)                                    ║\n" + 
					  			   "║ >For one attempt maximum Rs.10000 only allowable  ║\n" +		
					  			   "╚═══════════════════════════════════════════════════╝\n");
			  creditAmount();
			  
		}
		return getCreditAmount();
	}
	
	public int debitAmount() {
		Scanner getSnr = new Scanner(System.in);
		System.out.println("Enter the amount to debit");
		int amount = getSnr.nextInt();
		if((amount >= 100) && ((amount%100)==0) && (amount <= 10000)) {
			setDebitAmount(amount);
			System.out.println("\nCash details:");
			int fiveHundreds = amount / 500;
	        int remaining = amount % 500;
	        int twoHundreds = remaining / 200;
	        remaining %= 200;
	        int hundreds = remaining / 100;
	        System.out.println("Number of 500s : " + fiveHundreds);
	        System.out.println("Number of 200s : " + twoHundreds);
	        System.out.println("Number of 100s : " + hundreds);
		}
		else {
			  System.out.println("\n╔═══════════════════════════════════════════════════╗\n" +
					  			   "║       	        Note⚠️         		    ║\n" +
					  			   "║ >Amount should be greater than 100                ║\n" +
					  			   "║ >Amount should be multiple of 100                 ║\n" +
					  			   "║ (Ex. 500, 800)                                    ║\n" + 
					  			   "║ >For one attempt maximum Rs.10000 only allowable  ║\n" +		
					  			   "╚═══════════════════════════════════════════════════╝\n");
			  debitAmount();
		}
		return getDebitAmount();
	}
	
}
