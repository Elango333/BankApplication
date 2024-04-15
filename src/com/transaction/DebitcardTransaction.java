package com.transaction;

import java.util.Scanner;

import com.home.HomePage;

public class DebitcardTransaction extends Transaction implements DebitcardTransactionInterface{
	@Override
	public void showDebitcardFeature(int sessionID, long debitcardNumber) {
		TransactionDAO transactionDAO = new TransactionDAO();
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
		  
		  Scanner showDebitcardFeatureSnr = new Scanner(System.in);
		  int option = showDebitcardFeatureSnr.nextInt();
		  switch(option) {
		  case 1:
			  int debitAmount = getAmount();
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
			  int creditAmount = payAmount();
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

}
