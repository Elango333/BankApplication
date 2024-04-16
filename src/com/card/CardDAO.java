package com.card;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.utils.ConstantFile;
import com.utils.DatabaseConnection;

public class CardDAO {
	 private DatabaseConnection connection = DatabaseConnection.getInstance();
	 private Connection conn = connection.getConnection();
	 
	 public long storeCreditcardDetails(Creditcard ccDetails,int sessionID,double serviceChargePern) {
	     long creditcardNumber = 0;
		 try {
		      PreparedStatement statement = conn.prepareStatement(ConstantFile.insert_query_for_creditcardDetails, Statement.RETURN_GENERATED_KEYS);
		      Date sqlDateForValidFrom = Date.valueOf(ccDetails.getValidFrom());
		      Date sqlDateForValidTo = Date.valueOf(ccDetails.getValidUpto());
		      statement.setInt(1, sessionID);
		      statement.setInt(2, ccDetails.getInitBalance());
		      statement.setInt(3, ccDetails.getCvv());
		      statement.setString(4, ccDetails.getNameOnCard());
		      statement.setDate(5, sqlDateForValidFrom);
		      statement.setDate(6, sqlDateForValidTo);
		      statement.setFloat(7, (float) serviceChargePern);
		      statement.setInt(8, 0);
		      int rowsAffected = statement.executeUpdate();
		      if (rowsAffected > 0) {
		    	  ResultSet generatedKeys = statement.getGeneratedKeys();
		    	  if (generatedKeys.next()) {
		    		  creditcardNumber = generatedKeys.getLong(1); 
		    	  }
		      } 
		    } catch (SQLException e) {
		      System.out.println("SQL Exception occurred in storeCreditcardDetails method");
		      e.printStackTrace();
		    }
		    return creditcardNumber;
		  }
	 
	 public long storeDebitcardDetails(Debitcard dcDetails,int sessionID) {
		long debitCardNumber = 0;
		 try {
		      PreparedStatement statement = conn.prepareStatement(ConstantFile.insert_query_for_debitcardDetails, Statement.RETURN_GENERATED_KEYS);
		      Date sqlDateForValidFrom = Date.valueOf(dcDetails.getValidFrom());
		      Date sqlDateForValidTo = Date.valueOf(dcDetails.getValidUpto());
		      statement.setInt(1, sessionID);
		      statement.setInt(2, dcDetails.getInitBalance());
		      statement.setInt(3, dcDetails.getCvv());
		      statement.setString(4, dcDetails.getNameOnCard());
		      statement.setDate(5, sqlDateForValidFrom);
		      statement.setDate(6, sqlDateForValidTo);
		      int rowsAffected = statement.executeUpdate();
		      if (rowsAffected > 0) {
		    	  ResultSet generatedKeys = statement.getGeneratedKeys();
		    	  if (generatedKeys.next()) {
		    		  debitCardNumber = generatedKeys.getLong(1); 
		    	  }
		      } 
		    } catch (SQLException e) {
		      System.out.println("SQL Exception occurred in storeDebitcardDetails method");
		      e.printStackTrace();
		    }
		    return debitCardNumber;
	 }
	 
	  public long getDebitCardNumber(int sessionID) {
		  Scanner debitcardSnr = new Scanner(System.in);
		  long debitcardNumber = 0;
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_debitcardNumber);
			  statement.setInt(1,  sessionID);
			  ResultSet resultset = statement.executeQuery();
			  System.out.println("----- Debitcard Number -----\n");
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
			  System.out.println("----- Creditcard Number -----\n");
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
 
	  public DebitcardDTO getDebitcardDetails(long debitcardNumber) {
		  DebitcardDTO debitcardDTO = new DebitcardDTO();
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_getDebitcardDetails);
			  statement.setLong(1, debitcardNumber);
			  ResultSet resultset = statement.executeQuery();
			  while(resultset.next()) {
				  debitcardDTO.setDebitcardNumber(resultset.getLong(1));
				  debitcardDTO.setCvv(resultset.getInt(2));
				  debitcardDTO.setName(resultset.getString(3));
				  debitcardDTO.setValidFromDB(resultset.getDate(4));
				  debitcardDTO.setValidToDB(resultset.getDate(5));
			  }
		  }
		  catch (SQLException e) {
		      System.out.println("SQL Exception occurred in getDebitcardDetails method");
		      e.printStackTrace();
		    } 
		  return debitcardDTO;
	  }
	  
	  public CreditcardDTO getCreditcardDetails(long creditcardNumber) {
		  CreditcardDTO creditcardDTO = new CreditcardDTO();
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_getCreditcardDetails);
			  statement.setLong(1, creditcardNumber);
			  ResultSet resultset = statement.executeQuery();
			  while(resultset.next()) {
				  creditcardDTO.setCreditcardNumber(resultset.getLong(1));
				  creditcardDTO.setCvv(resultset.getInt(2));
				  creditcardDTO.setName(resultset.getString(3));
				  creditcardDTO.setValidFromDB(resultset.getDate(4));
				  creditcardDTO.setValidToDB(resultset.getDate(5));
			  }
		  }
		  catch (SQLException e) {
		      System.out.println("SQL Exception occurred in getCreditcardDetails method");
		      e.printStackTrace();
		    } 
		  return creditcardDTO;
	  }
	  
	  public boolean isPinCreatedForDebitcard(long debitcardNumber) {
		  boolean isPasswordCreated = false;
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_isPasswordCreatedForDebitcard);
			  statement.setLong(1, debitcardNumber);
			  ResultSet resultset = statement.executeQuery();
			  if(resultset.next()) { 
				  if(!resultset.getString(1).equals(null)) {
					  isPasswordCreated = true;
				  }
			  }
		  }
		  catch (SQLException e) {
		      System.out.println("SQL Exception occurred in isPasswordCreatedForDebitcard method");
		      e.printStackTrace();
		    }
		 return isPasswordCreated; 
	  }
	  
	  public boolean isPinCreatedForCreditcard(long creditcardNumber) {
		  boolean isPasswordCreated = false;
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_isPasswordCreatedForCreditcard);
			  statement.setLong(1, creditcardNumber);
			  ResultSet resultset = statement.executeQuery();
			  if(resultset.next()) { 
				  if(!resultset.getString(1).equals(null)) {
					  isPasswordCreated = true;
				  }  
			  }
		  }
		  catch (SQLException e) {
		      System.out.println("SQL Exception occurred in isPasswordCreatedForCreditcard method");
		      e.printStackTrace();
		    }
		 return isPasswordCreated; 
	  }
	  
	  public boolean setPinForDebitcard(long debitcardNumber, int pinNumber) {
		  boolean isPasswordSet = false;
		  try {
			PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_setPasswordForDebitcard);
			statement.setInt(1, pinNumber);
			statement.setLong(2, debitcardNumber);
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected > 0) {
				isPasswordSet = true;	
			}
		  }
		  catch (SQLException e) {
		      System.out.println("SQL Exception occurred in setPasswordForDebitcard method");
		      e.printStackTrace();
		    }
		  return isPasswordSet;
	  }
	  
	  public boolean setPinForCreditcard(long creditcardNumber, int pinNumber) {
		  boolean isPasswordSet = false;
		  try {
			PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_setPasswordForCreditcard);
			statement.setInt(1, pinNumber);
			statement.setLong(2, creditcardNumber);
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected > 0) {
				isPasswordSet = true;	
			}
		  }
		  catch (SQLException e) {
		      System.out.println("SQL Exception occurred in setPasswordForCreditcard method");
		      e.printStackTrace();
		    }
		  return isPasswordSet;
	  }
}
