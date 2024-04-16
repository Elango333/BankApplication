package com.transaction;

import java.util.Scanner;

import com.home.HomePage;

public class CreditcardTransaction extends Transaction implements CreditcardTransactionInterface{

	@Override
	public void showCreditcardFeature(int sessionID, long creditcardNumber) {
		TransactionDAO transactionDAO = new TransactionDAO();
		  Scanner showCreditcardFeatureSnr = new Scanner(System.in);
		  System.out.println("Enter the pin number to proceed");
		  int pinNum = showCreditcardFeatureSnr.nextInt();
		  int correctPinNum = transactionDAO.isPinCorrectForCreditcard(creditcardNumber);
		  if(pinNum == correctPinNum) {
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
		  
		
		  int option = showCreditcardFeatureSnr.nextInt();
		  switch(option) {
		  case 1:
			  int debitAmount = debitAmount();
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
			  int creditAmount = creditAmount();
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
		  else {
				System.out.println("\n╔═════════════════════════════════╗\n" +
									 "║      Enter the correct pin      ║\n" +
									 "╚═════════════════════════════════╝\n");	
				  showCreditcardFeature(sessionID, creditcardNumber);
		  }
	}

	
	
	@Override
	public int calculateRepayableAmount(int debitAmount, int serviceCharge) {
		return ((debitAmount)+(debitAmount/serviceCharge));
	}

}
