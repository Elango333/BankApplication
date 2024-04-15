package com.card;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.utils.ConstantFile;
import com.utils.DatabaseConnection;

public class CardDAO {
	 private DatabaseConnection connection = DatabaseConnection.getInstance();
	 private Connection conn = connection.getConnection();
	 
	 public boolean storeCreditcardDetails(CreditcardDTO ccDetails) {
		 boolean IsStored = false;
		 try {
		      PreparedStatement statement = conn.prepareStatement(ConstantFile.insert_query_for_creditcardDetails);
		      Date sqlDate = Date.valueOf(ccDetails.getExpirydate());
		      statement.setInt(1, ccDetails.getCustomerID());
		      statement.setInt(2, ccDetails.getInitBalance());
		      statement.setInt(3, ccDetails.getCvv());
		      statement.setInt(4, ccDetails.getPassword());
		      statement.setString(5, ccDetails.getName());
		      statement.setDate(6, sqlDate);
		      statement.setInt(7, ccDetails.getServiceChargePerc());
		      statement.setInt(8, 0);
		      int rowsAffected = statement.executeUpdate();

		      if (rowsAffected > 0) {
		    	  IsStored = true;
		      } 

		    } catch (SQLException e) {
		      System.out.println("SQL Exception occurred in storeCreditcardDetails method");
		      e.printStackTrace();
		    }
		    return IsStored;
		  }
	 
	 public boolean storeDebitcardDetails(DebitcardDTO dcDetails) {
		 boolean IsStored = false;
		 try {
		      PreparedStatement statement = conn.prepareStatement(ConstantFile.insert_query_for_debitcardDetails);
		      Date sqlDate = Date.valueOf(dcDetails.getExpirydate());
		      statement.setInt(1, dcDetails.getCustomerID());
		      statement.setInt(2, dcDetails.getInitBalance());
		      statement.setInt(3, dcDetails.getCvv());
		      statement.setInt(4, dcDetails.getPassword());
		      statement.setString(5, dcDetails.getName());
		      statement.setDate(6, sqlDate);
		      int rowsAffected = statement.executeUpdate();

		      if (rowsAffected > 0) {
		    	  IsStored = true;
		      } 

		    } catch (SQLException e) {
		      System.out.println("SQL Exception occurred in storeDebitcardDetails method");
		      e.printStackTrace();
		    }
		    return IsStored;
	 }
	 
	  public long getDebitCardNumber(int sessionID) {
		  Scanner debitcardSnr = new Scanner(System.in);
		  long debitcardNumber = 0;
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_debitcardNumber);
			  statement.setInt(1,  sessionID);
			  ResultSet resultset = statement.executeQuery();
			  System.out.println("----- Debitcard Number -----");
			  while(resultset.next()) {
				 System.out.println("----- "+resultset.getLong(1)+ " -----\n");
			  }  
			  System.out.println("Enter the debit card number");
			  debitcardNumber = debitcardSnr.nextLong();
		  }
		  catch (SQLException e) {
		      System.out.println("SQL Exception occurred in getDebitCardNumber method");
		      e.printStackTrace();
		    } 
		  return debitcardNumber;
	  }
	  
	  
	  public long getCreditCardNumber(int sessionID) {
		  Scanner creditcardSnr = new Scanner(System.in);
		  long creditcardNumber = 0;
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_creditcardNumber);
			  statement.setInt(1,  sessionID);
			  ResultSet resultset = statement.executeQuery();
			  System.out.println("----- Creditcard Number -----");
			  while(resultset.next()) {
				 System.out.println("----- "+resultset.getLong(1)+ " -----\n");
			  }  
			  System.out.println("Enter the credit card number");
			  creditcardNumber = creditcardSnr.nextLong();
		  }
		  catch (SQLException e) {
		      System.out.println("SQL Exception occurred in getCreditCardNumber method");
		      e.printStackTrace();
		    } 
		  return creditcardNumber;
	  }
 
	  public void getDebitcardDetails(long debitcardNumber) {
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_getDebitcardDetails);
			  statement.setLong(1, debitcardNumber);
			  ResultSet resultset = statement.executeQuery();
			  System.out.println("----- Debitcard Details -----");
			  while(resultset.next()) {
				  System.out.println("Debitcard number : "+ resultset.getLong(1));
				  System.out.println("CVV              : " + resultset.getInt(2));
				  System.out.println("Password         : " + resultset.getInt(3));
				  System.out.println("Card holder name : " + resultset.getString(4));
				  System.out.println("Card expiry date : " + resultset.getDate(5));
			  }
		  }
		  catch (SQLException e) {
		      System.out.println("SQL Exception occurred in getDebitcardDetails method");
		      e.printStackTrace();
		    } 
	  }
	  
	  public void getCreditcardDetails(long creditcardNumber) {
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_getCreditcardDetails);
			  statement.setLong(1, creditcardNumber);
			  ResultSet resultset = statement.executeQuery();
			  System.out.println("----- Creditcard Details -----");
			  while(resultset.next()) {
				  System.out.println("Creditcard number : "+ resultset.getLong(1));
				  System.out.println("CVV               : " + resultset.getInt(2));
				  System.out.println("Password          : " + resultset.getInt(3));
				  System.out.println("Card holder name  : " + resultset.getString(4));
				  System.out.println("Card expiry date  : " + resultset.getDate(5));
			  }
		  }
		  catch (SQLException e) {
		      System.out.println("SQL Exception occurred in getCreditcardDetails method");
		      e.printStackTrace();
		    } 
	  }
}
