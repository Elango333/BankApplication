package com.card;

import java.util.Scanner;

import com.home.HomePage;

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
		  switch(option) {
		  case 1:
			  Debitcard debitcard = new Debitcard(100000);
			  debitcard.createDebitcard(sessionID);
			  homepage.askMenu(sessionID);
		  case 2:
			  Creditcard creditcard = new Creditcard(100000);
			  creditcard.createCreditcard(sessionID);
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
			 cardDAO.getDebitcardDetails(debitcardNumber);
			 homepage.askMenu(sessionID);
			 break;
		  case 2:
			  long creditcardNumber = cardDAO.getCreditCardNumber(sessionID); 
			  cardDAO.getCreditcardDetails(creditcardNumber);
			  homepage.askMenu(sessionID);
			  break;
		  case 3:
			  homepage.askMenu(sessionID);
		  }
	}
}
