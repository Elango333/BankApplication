package com.transaction;

import java.util.Scanner;

import com.card.CardDAO;
import com.card.CardFunctionality;
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
				  DebitcardTransaction debitcard = new DebitcardTransaction();
				  debitcard.showDebitcardFeature(sessionID, debitcardNumber); 
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
				  CreditcardTransaction creditcard = new CreditcardTransaction();
				  creditcard.showCreditcardFeature(sessionID, creditcardNumber);
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

}
