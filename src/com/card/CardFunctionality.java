package com.card;

import java.time.LocalDate;
import java.util.Scanner;

import com.home.HomePage;
import com.serviceCharge.CreditcardServiceCharge;

public class CardFunctionality {

	public void showMenu(int sessionID) {
		Scanner askMenuSnr = new Scanner(System.in);
		  System.out.println("\n" +
			      "╔══════════════════════════════════════════════╗\n" +
			      "║                                              ║\n" +
			      "║      Create new Debit card   - Press (1)     ║\n" +
			      "║                                              ║\n" +
			      "║      Create new Credit card  - Press (2)     ║\n" +
			      "║                                              ║\n" +
			      "║      Back                    - Press (3)     ║\n" +
			      "║                                              ║\n" +
			      "╚══════════════════════════════════════════════╝\n\n");
		  int option = askMenuSnr.nextInt();
		  HomePage homepage = new HomePage();
		  CardDAO cardDAO = new CardDAO();
		  switch(option) {
		  case 1:
			  long debitcardNumber = createDebitcard(sessionID);
			  int pinNumberForDebitcard = setATMPin();
			  boolean isPinSetedForDebitcard = cardDAO.setPinForDebitcard(debitcardNumber, pinNumberForDebitcard);
			  if(isPinSetedForDebitcard) {
				   System.out.println("\n╔═══════════════════════════════════╗\n" +
						  				"║  Pin number successfully created! ║\n" +
						  				"╚═══════════════════════════════════╝\n");  
			  }
			  else {
				  System.out.println("\n╔═══════════════════════════════════╗\n" +
			  						   "║    Unable to create Pin number!   ║\n" +
			  						   "╚═══════════════════════════════════╝\n");   
			  }
			  homepage.askMenu(sessionID);
		  case 2:
			  long creditcardNumber = createCreditcard(sessionID);
			  int pinNumberForcreditcard = setATMPin();
			  boolean isPinSetedForCreditcard = cardDAO.setPinForCreditcard(creditcardNumber, pinNumberForcreditcard);
			  if(isPinSetedForCreditcard) {
				   System.out.println("\n╔═══════════════════════════════════╗\n" +
						  				"║  Pin number successfully created! ║\n" +
						  				"╚═══════════════════════════════════╝\n");  
			  }
			  else {
				  System.out.println("\n╔═══════════════════════════════════╗\n" +
			  						   "║    Unable to create Pin number!   ║\n" +
			  						   "╚═══════════════════════════════════╝\n");   
			  }
			  homepage.askMenu(sessionID);
			  break;
		  case 3:
			  homepage.askMenu(sessionID);
			  break;
		  default:
		  }

	}
	
	public void viewCardDetails(int sessionID) {
		Scanner viewCardDetailsSnr = new Scanner(System.in);
		  System.out.println("\n" +
			      "╔═════════════════════════════════════════════╗\n" +
			      "║                                             ║\n" +
			      "║     View debit card details  - Press (1)    ║\n" +
			      "║                                             ║\n" +
			      "║     View credit card details - Press (2)    ║\n" +
			      "║                                             ║\n" +
			      "║     Back                     - Press (3)    ║\n" +
			      "║                                             ║\n" +
			      "╚═════════════════════════════════════════════╝\n\n");
		  
		  int option = viewCardDetailsSnr.nextInt();
		  CardDAO cardDAO = new CardDAO();
		  HomePage homepage = new HomePage();
		  switch(option) {
		  case 1:
			 long debitcardNumber = cardDAO.getDebitCardNumber(sessionID); 
			 DebitcardDTO debitcardDTO = cardDAO.getDebitcardDetails(debitcardNumber);
			  System.out.println("----- Debitcard Details -----\n");
			  System.out.println("Debitcard number : " + debitcardDTO.getDebitcardNumber());
			  System.out.println("CVV              : " + debitcardDTO.getCvv());
			  System.out.println("Card holder name : " + debitcardDTO.getName());
			  System.out.println("Card valid from  : " + debitcardDTO.getValidFromDB());
			  System.out.println("Card valid to    : " + debitcardDTO.getValidToDB());
			  System.out.println("-----       -----       -----");
			 homepage.askMenu(sessionID);
			 break;
		  case 2:
			  long creditcardNumber = cardDAO.getCreditCardNumber(sessionID); 
			  CreditcardDTO creditcardDTO = cardDAO.getCreditcardDetails(creditcardNumber);
			  System.out.println("----- Creditcard Details -----\n");
			  System.out.println("Creditcard number : " + creditcardDTO.getCreditcardNumber());
			  System.out.println("CVV               : " + creditcardDTO.getCvv());
			  System.out.println("Card holder name  : " + creditcardDTO.getName());
			  System.out.println("Card valid from   : " + creditcardDTO.getValidFromDB());
			  System.out.println("Card valid to     : " + creditcardDTO.getValidToDB());
			  System.out.println("-----       -----       -----");
			  homepage.askMenu(sessionID);
			  break;
		  case 3:
			  homepage.askMenu(sessionID);
		  }
	}
	
	public int setATMPin() {
		System.out.println("\nCreate ATM card Pin number");
		System.out.println("\n╔═════════════════════════════════╗\n" +
							 "║  Pin number must have 4 digits! ║\n" +
							 "╚═════════════════════════════════╝\n");
		Scanner getPinNumSnr = new Scanner(System.in);
		int pinNum = getPinNumSnr.nextInt();
		return pinNum;
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
	
	public int generateCVV(int sessionID) {
		int cvv = (int) (sessionID%1000);
		return cvv;
	}
	
	public long createCreditcard(int sessionID) {
		Creditcard creditcard = new Creditcard();
		long creditcardNumber = 0;
		creditcard.setNameOnCard(getNameforCreatingCard());
		creditcard.setValidFrom(getValidFromDate());
		creditcard.setValidUpto(getValidToDate());
		creditcard.setCvv(generateCVV(sessionID));
		creditcard.setInitBalance(100000);
		CreditcardServiceCharge serviceCharge = new CreditcardServiceCharge();
		double serviceChargePerc = serviceCharge.getCreditcardServiceCharge(creditcard.getInitBalance());
		CardDAO cardDAO = new CardDAO();
		creditcardNumber = cardDAO.storeCreditcardDetails(creditcard, sessionID, serviceChargePerc);
		if(creditcardNumber > 0) {
			System.out.println("\n╔══════════════════════════════════╗\n" +
								 "║ Creditcard successfully created! ║\n" +
								 "╚══════════════════════════════════╝\n\n");
			System.out.println("Your Creditcard number : "+ creditcardNumber);

		}
		else {
			System.out.println("\n╔═════════════════════════════════╗\n" +
								 "║   Unable to create Creditcard!  ║\n" +
								 "╚═════════════════════════════════╝\n");
		}
		return creditcardNumber;
	}
	
	public long createDebitcard(int sessionID) {
		Debitcard debitcard = new Debitcard();
		long debitcardNumber = 0;
		debitcard.setNameOnCard(getNameforCreatingCard());
		debitcard.setValidFrom(getValidFromDate());
		debitcard.setValidUpto(getValidToDate());
		debitcard.setCvv(generateCVV(sessionID));
		debitcard.setInitBalance(100000);
		CardDAO cardDAO = new CardDAO();
		debitcardNumber = cardDAO.storeDebitcardDetails(debitcard, sessionID);
		if(debitcardNumber > 0) {
			System.out.println("\n╔═════════════════════════════════╗\n" +
								 "║ Debitcard successfully created! ║\n" +
								 "╚═════════════════════════════════╝\n\n");
			System.out.println("Your Debitcard number : " + debitcardNumber);

		}
		else {
			System.out.println("\n╔════════════════════════════════╗\n" +
								 "║   Unable to create Debitcard!  ║\n" +
								 "╚════════════════════════════════╝\n");
		}
		return debitcardNumber;
	}

}
