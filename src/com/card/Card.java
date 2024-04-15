package com.card;

import java.util.Scanner;
import java.time.LocalDate;

public class Card {
	public int initBalance;
	
	
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
	
	
	public int getATMPin() {
		System.out.println("\n╔═════════════════════════════════╗\n" +
							 "║  Pin number must have 4 digits! ║\n" +
							 "╚═════════════════════════════════╝\n");
		System.out.println("Create ATM card Pin number");
		Scanner getPinNumSnr = new Scanner(System.in);
		int pinNum = getPinNumSnr.nextInt();
		return pinNum;
	}
	
	public static LocalDate getExpiryDate() {
		LocalDate today = LocalDate.now();
		LocalDate fiveYearsLater = today.plusYears(5);
		return fiveYearsLater;
	}
	
	
}
