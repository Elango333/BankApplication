package com.transaction;

import java.util.Scanner;
import com.card.CardDAO;
import com.home.HomePage;

public class TransactionFunctionality {

	public void askMenu(int sessionID) {
		Scanner askMenuSnr = new Scanner(System.in);
		  System.out.println("\n" +
			      "╔══════════════════════════════════════════════╗\n" +
			      "║                                              ║\n" +
			      "║   Debit card Transactions       - Press (1)  ║\n" +
			      "║                                              ║\n" +
			      "║   Credit card Transactions      - Press (2)  ║\n" +
			      "║                                              ║\n" +
			      "║   Back                          - Press (3)  ║\n" +
			      "║                                              ║\n" +
			      "╚══════════════════════════════════════════════╝\n\n");
		  
		  int option = askMenuSnr.nextInt();
		  CardDAO cardDAO = new CardDAO();
		  switch(option) {
		  case 1:
			  long debitcardNumber = cardDAO.getDebitCardNumber(sessionID);
			  boolean isPasswordCreatedForDebitcard = cardDAO.isPinCreatedForDebitcard(debitcardNumber);
			  if(isPasswordCreatedForDebitcard) {
				  showDebitcardFeature(sessionID, debitcardNumber); 
			  }
			  else {
				  	System.out.println("Create ATM card Pin number");  
					System.out.println("\n╔═════════════════════════════════╗\n" +
										 "║  Pin number must have 4 digits! ║\n" +
										 "╚═════════════════════════════════╝\n");
					
			  }
			 
			  break;
		  case 2:
			  long creditcardNumber = cardDAO.getCreditCardNumber(sessionID);
			  boolean isPasswordCreatedForCreditcard = cardDAO.isPinCreatedForCreditcard(creditcardNumber);
			  if(isPasswordCreatedForCreditcard) {
				  showCreditcardFeature(sessionID, creditcardNumber);
			  }
			  else {
					System.out.println("\n╔═════════════════════════════════╗\n" +
										 "║  Pin number must have 4 digits! ║\n" +
										 "╚═════════════════════════════════╝\n");
					System.out.println("Create ATM card Pin number");  
			  }
			  break;
		  case 3:
			  HomePage homepage = new HomePage();
			  homepage.askMenu(sessionID);
			  break;
		  default:
		  }
	}
	
	
	public  int creditAmount() {
		Scanner paySnr = new Scanner(System.in);
		System.out.println("Enter the amount to credit");
		int amount = paySnr.nextInt();
		if((amount >= 100) && ((amount%100)==0) && (amount <= 10000)) {
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
		return amount;
	}
	
	public int debitAmount() {
		Scanner getSnr = new Scanner(System.in);
		System.out.println("Enter the amount to debit");
		int amount = getSnr.nextInt();
		if((amount >= 100) && ((amount%100)==0) && (amount <= 10000)) {
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
		return amount;
	}
	
	
	public int calculateRepayableAmount(int debitAmount, int serviceCharge) {
		return ((debitAmount)+(debitAmount/serviceCharge));
	}
	
	
	public void showCreditcardFeature(int sessionID, long creditcardNumber) {
		TransactionDAO transactionDAO = new TransactionDAO();
		CreditcardTransaction creditcardTransaction = new CreditcardTransaction();
		  Scanner showCreditcardFeatureSnr = new Scanner(System.in);
		  System.out.println("\n" +
			      "╔════════════════════════════════════╗\n" +
			      "║                                    ║\n" +
			      "║   To debit money      - Press (1)  ║\n" +
			      "║                                    ║\n" +
			      "║   To check loan money - Press (2)  ║\n" +
			      "║                                    ║\n" +
			      "║   To pay loan money   - Press (3)  ║\n" +
			      "║                                    ║\n" +
			      "║   To check balance    - Press (4)  ║\n" +
			      "║                                    ║\n" +
			      "║   Back                - Press (5)  ║\n" +
			      "║                                    ║\n" +
			      "╚════════════════════════════════════╝\n\n");
		  
		
		  int option = showCreditcardFeatureSnr.nextInt();
		  System.out.println("Enter the pin number to proceed");
		  int pinNum = showCreditcardFeatureSnr.nextInt();
		  int correctPinNum = transactionDAO.isPinCorrectForCreditcard(creditcardNumber);
		  if(pinNum == correctPinNum) {
		  switch(option) {
		  case 1:
			  creditcardTransaction.setAmount(debitAmount());
			  boolean isPaymentDebited = transactionDAO.creditcardDebitAmount(creditcardTransaction.getAmount(), sessionID, creditcardNumber);
			  if(isPaymentDebited) {
				System.out.println("\n╔═════════════════════════════════╗\n" +
									 "║  Payment Debited Successfully!  ║\n" +
									 "╚═════════════════════════════════╝\n");
			  }
			  else {
				System.out.println("\n╔═════════════════════════════════╗\n" +
						  		     "║   Unable to debit the payment!  ║\n" +
						           	 "╚═════════════════════════════════╝\n");
			  
			  }
	
			  showCreditcardFeature(sessionID, creditcardNumber);
			  break;
		  case 2:
			  System.out.println("Your loan amount : Rs." + transactionDAO.getCreditcardRepayableAmount(creditcardNumber));
			  showCreditcardFeature(sessionID, creditcardNumber);
			  break;
		  case 3:
			  creditcardTransaction.setAmount(creditAmount());
			  boolean isPaymentCredited = transactionDAO.creditcardCreditRepayableAmount(creditcardTransaction.getAmount(), sessionID, creditcardNumber);
			  if(isPaymentCredited) {
					System.out.println("\n╔═════════════════════════════════╗\n" +
										 "║  Payment Credited Successfully! ║\n" +
										 "╚═════════════════════════════════╝\n");
				  }
				  else {
					System.out.println("\n╔═════════════════════════════════╗\n" +
							  		     "║   Unable to credit the payment! ║\n" +
							           	 "╚═════════════════════════════════╝\n");
				  }
			  showCreditcardFeature(sessionID, creditcardNumber);
			  break;
		  case 4:
			  System.out.println("Your balance amount : Rs." + transactionDAO.getCreditcardBalanceAmount(sessionID, creditcardNumber));
			  showCreditcardFeature(sessionID, creditcardNumber);
			  break;
		  case 5:
			  HomePage homepage = new HomePage();
			  homepage.askMenu(sessionID);
			  break;
		  default:
			  
		  }
		  }
		  else {
				System.out.println("\n╔═════════════════════════════════╗\n" +
									 "║      Enter the correct pin      ║\n" +
									 "╚═════════════════════════════════╝\n");	
				  showCreditcardFeature(sessionID, creditcardNumber);
		  }
	}
	
	public void showDebitcardFeature(int sessionID, long debitcardNumber) {
		DebitcardTransaction debitcardTransaction = new DebitcardTransaction();
		TransactionDAO transactionDAO = new TransactionDAO();
		  Scanner showDebitcardFeatureSnr = new Scanner(System.in);
		  System.out.println("\n" +
			      "╔═══════════════════════════════════╗\n" +
			      "║                                   ║\n" +
			      "║    To debit money    - Press (1)  ║\n" +
			      "║                                   ║\n" +
			      "║    To credit money   - Press (2)  ║\n" +
			      "║                                   ║\n" +
			      "║    To view balance   - Press (3)  ║\n" +
			      "║                                   ║\n" +
			      "║    Back              - Press (4)  ║\n" +
			      "║                                   ║\n" +
			      "╚═══════════════════════════════════╝\n\n");
		  
		  int option = showDebitcardFeatureSnr.nextInt();
		  System.out.println("Enter the pin number to proceed");
		  int pinNum = showDebitcardFeatureSnr.nextInt();
		  int correctPinNum = transactionDAO.isPinCorrectForDebitcard(debitcardNumber);
		  if(pinNum == correctPinNum) {
		  switch(option) {
		  case 1:
			  debitcardTransaction.setAmount(debitAmount());
			  boolean isPaymentDebited = transactionDAO.debitcardDebitAmount(debitcardTransaction.getAmount(), sessionID, debitcardNumber);
			  if(isPaymentDebited) {
				System.out.println("\n╔═════════════════════════════════╗\n" +
									 "║  Payment Debited Successfully!  ║\n" +
									 "╚═════════════════════════════════╝\n");
			  }
			  else {
				System.out.println("\n╔═════════════════════════════════╗\n" +
						  		     "║   Unable to debit the payment!  ║\n" +
						           	 "╚═════════════════════════════════╝\n");
			  }
			  showDebitcardFeature(sessionID, debitcardNumber);
			  break;
		  case 2:
			  debitcardTransaction.setAmount(creditAmount());
			  boolean isPaymentCredited = transactionDAO.debitcardCreditAmount(debitcardTransaction.getAmount(), sessionID, debitcardNumber);
			  if(isPaymentCredited) {
					System.out.println("\n╔═════════════════════════════════╗\n" +
										 "║  Payment Credited Successfully! ║\n" +
										 "╚═════════════════════════════════╝\n");
				  }
				  else {
					System.out.println("\n╔═════════════════════════════════╗\n" +
							  		     "║   Unable to credit the payment! ║\n" +
							           	 "╚═════════════════════════════════╝\n");
				  }
			  showDebitcardFeature(sessionID, debitcardNumber);
			  break;
		  case 3:
		      System.out.println("Your Balance amount : Rs." + transactionDAO.getDebitcardBalanceAmount(sessionID, debitcardNumber));
		      showDebitcardFeature(sessionID, debitcardNumber);
			  break;
		  case 4:
			  HomePage homepage = new HomePage();
			  homepage.askMenu(sessionID);
		  default:
			  
		  }
		  }
		  else {
				System.out.println("\n╔═════════════════════════════════╗\n" +
									 "║      Enter the correct pin      ║\n" +
									 "╚═════════════════════════════════╝\n");	
				  showDebitcardFeature(sessionID, debitcardNumber);
		  }
	}

}
