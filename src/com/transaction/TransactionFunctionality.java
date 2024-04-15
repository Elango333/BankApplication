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
			  DebitcardTransaction debitcard = new DebitcardTransaction();
			  debitcard.showDebitcardFeature(sessionID, debitcardNumber);
			  break;
		  case 2:
			  long creditcardNumber = cardDAO.getCreditCardNumber(sessionID);
			  CreditcardTransaction creditcard = new CreditcardTransaction();
			  creditcard.showCreditcardFeature(sessionID, creditcardNumber);
			  break;
		  case 3:
			  HomePage homepage = new HomePage();
			  homepage.askMenu(sessionID);
			  break;
		  default:
		  }
	}
}
