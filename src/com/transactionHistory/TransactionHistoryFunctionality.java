package com.transactionHistory;

import java.util.Scanner;

import com.card.CardDAO;
import com.home.HomePage;
import com.transaction.CreditcardTransaction;
import com.transaction.DebitcardTransaction;

public class TransactionHistoryFunctionality {

	public void askMenu(int sessionID) {
		Scanner askMenuSnr = new Scanner(System.in);
		  System.out.println("\n" +
			      "╔════════════════════════════════════════════════════════╗\n" +
			      "║                                                        ║\n" +
			      "║   View Debitcard transaction history      - Press (1)  ║\n" +
			      "║                                                        ║\n" +
			      "║   View Creditcard transaction history     - Press (2)  ║\n" +
			      "║                                                        ║\n" +
			      "║   Back                                    - Press (3)  ║\n" +
			      "║                                                        ║\n" +
			      "╚════════════════════════════════════════════════════════╝\n\n");
		  
		  int option = askMenuSnr.nextInt();
		  CardDAO cardDAO = new CardDAO();
		  switch(option) {
		  case 1:
			  long debitcardNumber = cardDAO.getDebitCardNumber(sessionID);
			  DebitcardTransactionHistory debitcard = new DebitcardTransactionHistory();
			  debitcard.showFeatures(sessionID, debitcardNumber);
			  break;
		  case 2:
			  long creditcardNumber = cardDAO.getCreditCardNumber(sessionID);
			  CreditcardTransactionHistory creditcard = new CreditcardTransactionHistory();
			  creditcard.showFeatures(sessionID, creditcardNumber);
			  break;
		  case 3:
			  HomePage homepage = new HomePage();
			  homepage.askMenu(sessionID);
			  break;
		  default:
		  }
	}
	
}
