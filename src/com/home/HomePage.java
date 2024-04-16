package com.home;

import java.util.Scanner;

import com.card.*;
import com.login.Login;
import com.login.Register;
import com.transaction.TransactionFunctionality;
import com.transactionHistory.TransactionHistoryFunctionality;


public class HomePage {

	public static void main(String[] args) {
		  HomePage homepage = new HomePage();
		    homepage.homePage();
	}
	
	public void homePage() {
		  Scanner homePageSnr = new Scanner(System.in);
		    System.out.println("\n" +
		      "╔═══════════════════════════════════╗\n" +
		      "║                                   ║\n" +
		      "║    Register          - Press (1)  ║\n" +
		      "║                                   ║\n" +
		      "║    Login             - Press (2)  ║\n" +
		      "║                                   ║\n" +
		      "╚═══════════════════════════════════╝\n\n");

		    int option = homePageSnr.nextInt();
		 
		    switch(option) {
		    case 1:
		    	Register registerpage = new Register();
		    	registerpage.register();
		    	break;
		    case 2:
		    	Login loginpage = new Login();
		    	loginpage.login();
		    	
		    	break;
		    default:
			      homePage();
		    }
		    homePageSnr.close();
	}
	
	public void askMenu(int sessionID) {
		Scanner askMenuSnr = new Scanner(System.in);
		  System.out.println("\n" +
			      "╔══════════════════════════════════════════════╗\n" +
			      "║                                              ║\n" +
			      "║  Create new Debit/Credit card   - Press (1)  ║\n" +
			      "║                                              ║\n" +
			      "║  Make Transactions              - Press (2)  ║\n" +
			      "║                                              ║\n" +
			      "║  View Transaction history       - Press (3)  ║\n" +
			      "║                                              ║\n" +
			      "║  View Debit/Credit card details - Press (4)  ║\n" +
			      "║                                              ║\n" +
			      "╚══════════════════════════════════════════════╝\n\n");
		  
		  int option = askMenuSnr.nextInt();
		  CardFunctionality cardFunc = new CardFunctionality();
		  switch(option) {
		  case 1:
			  cardFunc.showMenu(sessionID);
			  break;
		  case 2:
			  TransactionFunctionality transactionFunc = new TransactionFunctionality();
			  transactionFunc.askMenu(sessionID);
			  break;
		  case 3:
			  TransactionHistoryFunctionality transactionHistoryFunc = new TransactionHistoryFunctionality();
			  transactionHistoryFunc.askMenu(sessionID);
			  break;
		  case 4:
			  cardFunc.viewCardDetails(sessionID);
			  break;
		  default:
		  }
	}
	
	public void askMenuIfNewUser(int sessionID) {
		Scanner askMenuSnr = new Scanner(System.in);
		  System.out.println("\n" +
			      "╔══════════════════════════════════════════════╗\n" +
			      "║  Create new Debit/Credit card   - Press (1)  ║\n" +
			      "╚══════════════════════════════════════════════╝\n\n");
		  
		  int option = askMenuSnr.nextInt();
		  if(option==1) {
			  CardFunctionality cardFunc = new CardFunctionality();
			  cardFunc.showMenu(sessionID);
		  }
		  else {
			  askMenuIfNewUser(sessionID);
		  }
	}
}
