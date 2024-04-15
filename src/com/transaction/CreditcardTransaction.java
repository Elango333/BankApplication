package com.transaction;

import java.util.Scanner;

import com.home.HomePage;

public class CreditcardTransaction extends Transaction implements CreditcardTransactionInterface{

	@Override
	public void showCreditcardFeature(int sessionID, long creditcardNumber) {
		TransactionDAO transactionDAO = new TransactionDAO();
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
		  
		  Scanner showCreditcardFeatureSnr = new Scanner(System.in);
		  int option = showCreditcardFeatureSnr.nextInt();
		  switch(option) {
		  case 1:
			  int debitAmount = getAmount();
			  boolean isPaymentDebited = transactionDAO.creditcardDebitAmount(debitAmount, sessionID, creditcardNumber);
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
			  int creditAmount = payAmount();
			  boolean isPaymentCredited = transactionDAO.creditcardCreditRepayableAmount(creditAmount, sessionID, creditcardNumber);
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

	
	
	@Override
	public int calculateRepayableAmount(int debitAmount, int serviceCharge) {
		return ((debitAmount)+(debitAmount/serviceCharge));
	}

}
