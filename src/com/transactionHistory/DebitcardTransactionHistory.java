package com.transactionHistory;

import java.util.Scanner;

import com.home.HomePage;

public class DebitcardTransactionHistory extends TransactionHistory{

	public void showFeatures(int sessionID, long debitcardNumber) {
		super.showFeatures(sessionID, debitcardNumber);
		TransactionHistoryDAO transactionhistory = new TransactionHistoryDAO();
		Scanner showFeaturesSnr = new Scanner(System.in);
		int option = showFeaturesSnr.nextInt();
		switch(option) {
		case 1:
			transactionhistory.getDebitcardTransactionHistoryByCurrentDate(debitcardNumber);
			showFeatures(sessionID, debitcardNumber);
			break;
		case 2:
			transactionhistory.getDebitcardTransactionHistoryByLastweek(debitcardNumber);
			showFeatures(sessionID, debitcardNumber);
			break;
		case 3:
			transactionhistory.getDebitcardTransactionHistoryByLastMonth(debitcardNumber);
			showFeatures(sessionID, debitcardNumber);
			break;
		case 4:
			HomePage homepage = new HomePage();
			homepage.askMenu(sessionID);
		}
	}
	
}
