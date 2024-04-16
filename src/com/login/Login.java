package com.login;

import java.util.Scanner;
import com.home.HomePage;


public class Login {
	 public static String customerName;
	 
	  public void login() {
	    Scanner loginSnr = new Scanner(System.in);
	    System.out.println("Enter the name to login:");
	    String name = loginSnr.nextLine();
	    customerName = name;
	    System.out.println("Enter the Password:");
	    String password = loginSnr.next();
	    LoginDAO loginFunctions = new LoginDAO();
	    int sessionID = loginFunctions.IsIdExistsForLogin(name, password);
	    HomePage homepage = new HomePage();
	    if (sessionID > 0) {
	      System.out.println("\n╔═══════════════════════════╗\n" +
	    		  			   "║  Logged in successfully!  ║\n" +
	    		  			   "╚═══════════════════════════╝\n");
	      boolean isCardExists = loginFunctions.IsCardExists(sessionID);
	      if(isCardExists) {
	    	  homepage.askMenu(sessionID);
	      }
	      else {
	    	  homepage.askMenuIfNewUser(sessionID);
	      }

	    
	      
	    } else {
	      System.out.println("\n╔══════════════════════════╗\n" +
	    		  			   "║   User does not exist!   ║\n" +
	    		  			   "║     Please Register!     ║\n" +
	    		  			   "╚══════════════════════════╝\n");

	      homepage.homePage();
	    }
	    loginSnr.close();
	  }
}
