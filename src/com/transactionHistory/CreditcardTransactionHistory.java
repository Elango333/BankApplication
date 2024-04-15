package com.transactionHistory;

import java.util.Scanner;

import com.home.HomePage;

public class CreditcardTransactionHistory extends TransactionHistory{

	public void showFeatures(int sessionID, long debitcardNumber) {
		super.showFeatures(sessionID, debitcardNumber);
		TransactionHistoryDAO transactionhistory = new TransactionHistoryDAO();
		Scanner showFeaturesSnr = new Scanner(System.in);
		int option = showFeaturesSnr.nextInt();
		switch(option) {
		case 1:
			transactionhistory.getCreditcardTransactionHistoryByCurrentDate(debitcardNumber);
			showFeatures(sessionID, debitcardNumber);
			break;
		case 2:
			transactionhistory.getCreditcardTransactionHistoryByLastweek(debitcardNumber);
			showFeatures(sessionID, debitcardNumber);
			break;
		case 3:
			transactionhistory.getCreditcardTransactionHistoryByLastMonth(debitcardNumber);
			showFeatures(sessionID, debitcardNumber);
			break;
		case 4:
			HomePage homepage = new HomePage();
			homepage.askMenu(sessionID);
		}
	}
}
