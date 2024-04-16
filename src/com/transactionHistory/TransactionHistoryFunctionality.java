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
			  debitcardHistoryFeatures(sessionID, debitcardNumber);
			  break;
		  case 2:
			  long creditcardNumber = cardDAO.getCreditCardNumber(sessionID);
			  creditcardHistoryFeatures(sessionID, creditcardNumber);
			  break;
		  case 3:
			  HomePage homepage = new HomePage();
			  homepage.askMenu(sessionID);
			  break;
		  default:
		  }
	}
	
	public void debitcardHistoryFeatures(int sessionID, long debitcardNumber) {
		 System.out.println("\n" +
			      "╔═══════════════════════════════════════════════════╗\n" +
			      "║                                                   ║\n" +
			      "║   View today transactions            - Press (1)  ║\n" +
			      "║                                                   ║\n" +
			      "║   View last 7 days transactions      - Press (2)  ║\n" +
			      "║                                                   ║\n" +
			      "║   View last 30 days transactions     - Press (3)  ║\n" +
			      "║                                                   ║\n" +
			      "║   Back                               - Press (4)  ║\n" +
			      "║                                                   ║\n" +
			      "╚═══════════════════════════════════════════════════╝\n\n");
		TransactionHistoryDAO transactionhistory = new TransactionHistoryDAO();
		Scanner showFeaturesSnr = new Scanner(System.in);
		int option = showFeaturesSnr.nextInt();
		switch(option) {
		case 1:
			transactionhistory.getCreditcardTransactionHistoryByCurrentDate(debitcardNumber);
			debitcardHistoryFeatures(sessionID, debitcardNumber);
			break;
		case 2:
			transactionhistory.getCreditcardTransactionHistoryByLastweek(debitcardNumber);
			debitcardHistoryFeatures(sessionID, debitcardNumber);
			break;
		case 3:
			transactionhistory.getCreditcardTransactionHistoryByLastMonth(debitcardNumber);
			debitcardHistoryFeatures(sessionID, debitcardNumber);
			break;
		case 4:
			HomePage homepage = new HomePage();
			homepage.askMenu(sessionID);
		}
	}
	
	public void creditcardHistoryFeatures(int sessionID, long debitcardNumber) {
		 System.out.println("\n" +
			      "╔═══════════════════════════════════════════════════╗\n" +
			      "║                                                   ║\n" +
			      "║   View today transactions            - Press (1)  ║\n" +
			      "║                                                   ║\n" +
			      "║   View last 7 days transactions      - Press (2)  ║\n" +
			      "║                                                   ║\n" +
			      "║   View last 30 days transactions     - Press (3)  ║\n" +
			      "║                                                   ║\n" +
			      "║   Back                               - Press (4)  ║\n" +
			      "║                                                   ║\n" +
			      "╚═══════════════════════════════════════════════════╝\n\n");
		TransactionHistoryDAO transactionhistory = new TransactionHistoryDAO();
		Scanner showFeaturesSnr = new Scanner(System.in);
		int option = showFeaturesSnr.nextInt();
		switch(option) {
		case 1:
			transactionhistory.getDebitcardTransactionHistoryByCurrentDate(debitcardNumber);
			creditcardHistoryFeatures(sessionID, debitcardNumber);
			break;
		case 2:
			transactionhistory.getDebitcardTransactionHistoryByLastweek(debitcardNumber);
			creditcardHistoryFeatures(sessionID, debitcardNumber);
			break;
		case 3:
			transactionhistory.getDebitcardTransactionHistoryByLastMonth(debitcardNumber);
			creditcardHistoryFeatures(sessionID, debitcardNumber);
			break;
		case 4:
			HomePage homepage = new HomePage();
			homepage.askMenu(sessionID);
		}
	}
	
	
}
