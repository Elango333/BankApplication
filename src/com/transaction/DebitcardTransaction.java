package com.transaction;

import java.util.Scanner;

import com.home.HomePage;

public class DebitcardTransaction extends Transaction implements DebitcardTransactionInterface{
	@Override
	public void showDebitcardFeature(int sessionID, long debitcardNumber) {
		TransactionDAO transactionDAO = new TransactionDAO();
		  Scanner showDebitcardFeatureSnr = new Scanner(System.in);
		  System.out.println("Enter the pin number to proceed");
		  int pinNum = showDebitcardFeatureSnr.nextInt();
		  int correctPinNum = transactionDAO.isPinCorrectForDebitcard(debitcardNumber);
		  if(pinNum == correctPinNum) {
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
		  switch(option) {
		  case 1:
			  int debitAmount = debitAmount();
			  boolean isPaymentDebited = transactionDAO.debitcardDebitAmount(debitAmount, sessionID, debitcardNumber);
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
			  int creditAmount = creditAmount();
			  boolean isPaymentCredited = transactionDAO.debitcardCreditAmount(creditAmount, sessionID, debitcardNumber);
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
