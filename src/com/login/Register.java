package com.login;

import java.util.Scanner;
import java.util.regex.Pattern;
import com.home.HomePage;


public class Register {
	  public void register() {
		  
		   System.out.println("\n" +
				      "╔════════════════════════════════════════╗\n" +
				      "║                                        ║\n" +
				      "║                  Note⚠️                ║\n" +
				      "║                                        ║\n" +
				      "║> Name must be above 3 characters.      ║\n" +
				      "║                                        ║\n" +
				      "║> Enter the valid mobile number.        ║\n" +
				      "║                                        ║\n" +
				      "║> Password must have one upper case,    ║\n" +
				      "║                                        ║\n" +
				      "║ one number and minimum 8 characters.   ║\n" +
				      "║                                        ║\n" +
				      "╚════════════════════════════════════════╝\n\n");
		   
		  
	    Scanner registerSnr = new Scanner(System.in);
	    System.out.println("Enter the name to register");
	    String name = registerSnr.nextLine();
	    // Minimum 3 characters for name
	    boolean minLengthConditionForName = name.length() >= 3;
	    if(!minLengthConditionForName) {
	    	  System.out.println("\n╔═════════════════════════════════╗\n" +
	    			  			   "║       Failed to Register!       ║\n" +
					               "║⚠️Name must be above 3 characters║\n" +
						           "╚═════════════════════════════════╝\n");
	    	  register();
	    }
	    System.out.println("Enter the mobile number:");
	    String mobileNumber = registerSnr.nextLine();
	    // MobileNumber check
	    boolean mobileNumberLength = mobileNumber.length() >= 10;
	    if(!mobileNumberLength) {
	    	  System.out.println("\n╔══════════════════════════════════╗\n" +
	    			  			   "║        Failed to Register!       ║\n" +
	    			  			   "║ ⚠️ Enter the valid mobile number ║\n" +
	    			  			   "╚══════════════════════════════════╝\n");
	    	  register();
	    }
	    System.out.println("Enter the Password:");
	    String password = registerSnr.nextLine();
	    // Minimum 8 characters for password
	    boolean minLengthConditionForPassword = password.length() >= 8;
	    // At least 1 uppercase letter
	    boolean uppercaseCondition = Pattern.compile("[A-Z]").matcher(password).find();
	    // At least 1 number
	    boolean numberCondition = Pattern.compile("\\d").matcher(password).find();
	    if((!minLengthConditionForPassword) || (!uppercaseCondition) || (!numberCondition)) {
	    	  System.out.println("\n╔════════════════════════════════════╗\n" +
	    			  			   "║       Failed to Register!          ║\n" +
	    			  			   "║⚠️Password must have one upper case,║\n" +
	    			  			   "║ one number and minimum 8 characters║\n" +
	                               "╚════════════════════════════════════╝\n");
	    	  register();
	    }
	    LoginDAO loginFunc = new LoginDAO();
	    long userNameExists = loginFunc.IsIdExistsForLogin(name, password);
	    HomePage homepage = new HomePage();
	    if (userNameExists > 0) {
	      System.out.println("\n╔═════════════════════════════════╗\n" +
	    		  			   "║       User already exists!      ║\n" +
	    		  			   "╚═════════════════════════════════╝\n");
	      homepage.homePage();
	    }

	    if (minLengthConditionForName && minLengthConditionForPassword && uppercaseCondition && numberCondition && mobileNumberLength && (userNameExists <= 0)) {
	    boolean IsAccountCreated = loginFunc.storeRegisterDetails(name, password, mobileNumber);
	      if (IsAccountCreated) {
	        System.out.println("\n╔═════════════════════════════════╗\n" +
	        					 "║     Successfully Registered!    ║\n" +
	        					 "╚═════════════════════════════════╝\n");
	        Login loginpage = new Login();
	        loginpage.login();
	      }
	      
	      else {
	        System.out.println("\n╔═════════════════════════════════╗\n" +
	        					 "║      ⚠️Failed to Register!      ║\n" +
	        					 "╚═════════════════════════════════╝\n");
	        homepage.homePage();
	      }
	    }
	    
	    else {
	      System.out.println("\n╔═════════════════════════════════╗\n" +
	    		  			   "║      ⚠️Failed to Register!      ║\n" +
	    		  			   "╚═════════════════════════════════╝\n");
	      homepage.homePage();
	    }

	    registerSnr.close();
	  }
}
