package com.card;

import java.util.Scanner;
import java.sql.Date;
import java.time.LocalDate;

public class Card {
	private int initBalance = 0;
	private String cardName;
	private int cvv;
	private long cardNumber;
	private String cardType;
	private String nameOnCard;
	private Date validFrom;
	private Date validUpto;
	
	
	public int getInitBalance() {
		return initBalance;
	}
	
	public String getNameforCreatingCard() {
		System.out.println("\n╔═════════════════════════════════╗\n" +
							 "║  Name characters between 3 - 12 ║\n" +
							 "╚═════════════════════════════════╝\n");
		System.out.println("Enter the ATM card display name");
		Scanner getNameSnr = new Scanner(System.in);
		String name = getNameSnr.nextLine();
		return name;
		}
	
	public LocalDate getValidFromDate() {
		LocalDate today = LocalDate.now();
		return today;
	}
	
	public LocalDate getValidToDate() {
		LocalDate today = LocalDate.now();
		LocalDate fiveYearsLater = today.plusYears(5);
		return fiveYearsLater;
	}
	
	
}
