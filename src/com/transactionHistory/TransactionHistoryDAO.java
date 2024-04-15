package com.transactionHistory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.utils.ConstantFile;
import com.utils.DatabaseConnection;

public class TransactionHistoryDAO {
	

	  private DatabaseConnection connection = DatabaseConnection.getInstance();
	  private Connection conn = connection.getConnection();
	
	  public void updateDebitcardHistory(int sessionID, long debitcardNumber, String transactionType) {
		  try {
		      PreparedStatement statement = conn.prepareStatement(ConstantFile.insert_query_for_debitcardTransactionHistory);
		  	  LocalDate today = LocalDate.now();
		      Date sqlDate = Date.valueOf(today);
		      statement.setInt(1, sessionID);
		      statement.setLong(2, debitcardNumber);
		      statement.setString(3, transactionType);
		      statement.setDate(4, sqlDate);
		      statement.executeUpdate();
		    } catch (SQLException e) {
		      System.out.println("SQL Exception occurred in updateDebitcardHistory method");
		      e.printStackTrace();
		    }  
	  }
	  
	  public void updateCreditcardHistory(int sessionID, long creditcardNumber, String transactionType) {
		  try {
		      PreparedStatement statement = conn.prepareStatement(ConstantFile.insert_query_for_creditcardTransactionHistory);
		  	  LocalDate today = LocalDate.now();
		      Date sqlDate = Date.valueOf(today);
		      statement.setInt(1, sessionID);
		      statement.setLong(2, creditcardNumber);
		      statement.setString(3, transactionType);
		      statement.setDate(4, sqlDate);
		      statement.executeUpdate();
		    } catch (SQLException e) {
		      System.out.println("SQL Exception occurred in updateCreditcardHistory method");
		      e.printStackTrace();
		    }  
	  }
	  
	  public void getDebitcardTransactionHistoryByCurrentDate(long debitcardNumber) {
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_getDebitcardTransactionHistoryByCurrentDate);
			  LocalDate today = LocalDate.now();
		      Date sqlDate = Date.valueOf(today);
			  statement.setLong(1,  debitcardNumber);
			  statement.setDate(2, sqlDate);
			  ResultSet resultset = statement.executeQuery();
			  while(resultset.next()) {
				 System.out.println("-----Today Transaction History -----");
				 System.out.println("Transaction Type: "+ resultset.getString(1));
				 System.out.println("Date :" + resultset.getDate(2));
				 System.out.println();
			  }
			  	System.out.println("----- ----- -----");
		  }
		  catch (SQLException e) {
		      System.out.println("SQL Exception occurred in getDebitcardTransactionHistoryByCurrentDate method");
		      e.printStackTrace();
		    }  
	  }
	  
	  
	  public void getCreditcardTransactionHistoryByCurrentDate(long creditcardNumber) {
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_getCreditcardTransactionHistoryByCurrentDate);
			  LocalDate today = LocalDate.now();
		      Date sqlDate = Date.valueOf(today);
			  statement.setLong(1,  creditcardNumber);
			  statement.setDate(2, sqlDate);
			  ResultSet resultset = statement.executeQuery();
			  while(resultset.next()) {
				 System.out.println("-----Today Transaction History -----");
				 System.out.println("Transaction Type: "+ resultset.getString(1));
				 System.out.println("Date :" + resultset.getDate(2));
				 System.out.println();
			  }
			  	System.out.println("----- ----- -----");
		  }
		  catch (SQLException e) {
		      System.out.println("SQL Exception occurred in getCreditcardTransactionHistoryByCurrentDate method");
		      e.printStackTrace();
		    }  
	  }
	  
	  

	  public void getDebitcardTransactionHistoryByLastweek(long debitcardNumber) {
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_getDebitcardTransactionHistoryByLastweek);
			  LocalDate today = LocalDate.now();
		      Date sqlDate = Date.valueOf(today);
		      LocalDate sevenDaysBefore = today.minusDays(7);
		      Date sqlDateForSevenDaysBefore = Date.valueOf(sevenDaysBefore);
			  statement.setLong(1,  debitcardNumber);
			  statement.setDate(2, sqlDateForSevenDaysBefore);
			  statement.setDate(3,  sqlDate);
			  ResultSet resultset = statement.executeQuery();
			  while(resultset.next()) {
				 System.out.println("----- Last week Transaction History -----");
				 System.out.println("Transaction Type: "+ resultset.getString(1));
				 System.out.println("Date :" + resultset.getDate(2));
				 System.out.println();
			  }
			  	System.out.println("----- ----- -----");
		  }
		  catch (SQLException e) {
		      System.out.println("SQL Exception occurred in getDebitcardTransactionHistoryByLastweek method");
		      e.printStackTrace();
		    }  
	  }
	  
	  public void getCreditcardTransactionHistoryByLastweek(long creditcardNumber) {
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_getCreditcardTransactionHistoryByLastweek);
			  LocalDate today = LocalDate.now();
		      Date sqlDate = Date.valueOf(today);
		      LocalDate sevenDaysBefore = today.minusDays(7);
		      Date sqlDateForSevenDaysBefore = Date.valueOf(sevenDaysBefore);
			  statement.setLong(1,  creditcardNumber);
			  statement.setDate(2, sqlDateForSevenDaysBefore);
			  statement.setDate(3,  sqlDate);
			  ResultSet resultset = statement.executeQuery();
			  while(resultset.next()) {
				 System.out.println("----- Last week Transaction History -----");
				 System.out.println("Transaction Type: "+ resultset.getString(1));
				 System.out.println("Date :" + resultset.getDate(2));
				 System.out.println();
			  }
			  	System.out.println("----- ----- -----");
		  }
		  catch (SQLException e) {
		      System.out.println("SQL Exception occurred in getCreditcardTransactionHistoryByLastweek method");
		      e.printStackTrace();
		    }  
	  }
	  
	  
	  public void getDebitcardTransactionHistoryByLastMonth(long debitcardNumber) {
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_getDebitcardTransactionHistoryByLastmonth);
			  LocalDate today = LocalDate.now();
		      Date sqlDate = Date.valueOf(today);
		      LocalDate thirtyDaysBefore = today.minusDays(30);
		      Date sqlDateForSevenDaysBefore = Date.valueOf(thirtyDaysBefore);
			  statement.setLong(1,  debitcardNumber);
			  statement.setDate(2, sqlDateForSevenDaysBefore);
			  statement.setDate(3,  sqlDate);
			  ResultSet resultset = statement.executeQuery();
			  while(resultset.next()) {
				 System.out.println("----- Last month Transaction History -----");
				 System.out.println("Transaction Type: "+ resultset.getString(1));
				 System.out.println("Date :" + resultset.getDate(2));
				 System.out.println();
			  }
			  	System.out.println("----- ----- -----");
		  }
		  catch (SQLException e) {
		      System.out.println("SQL Exception occurred in getDebitcardTransactionHistoryByLastMonth method");
		      e.printStackTrace();
		    }  
	  }
	  
	  public void getCreditcardTransactionHistoryByLastMonth(long creditcardNumber) {
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_getCreditcardTransactionHistoryByLastmonth);
			  LocalDate today = LocalDate.now();
		      Date sqlDate = Date.valueOf(today);
		      LocalDate thirtyDaysBefore = today.minusDays(30);
		      Date sqlDateForSevenDaysBefore = Date.valueOf(thirtyDaysBefore);
			  statement.setLong(1,  creditcardNumber);
			  statement.setDate(2, sqlDateForSevenDaysBefore);
			  statement.setDate(3,  sqlDate);
			  ResultSet resultset = statement.executeQuery();
			  while(resultset.next()) {
				 System.out.println("----- Last month Transaction History -----");
				 System.out.println("Transaction Type: "+ resultset.getString(1));
				 System.out.println("Date :" + resultset.getDate(2));
				 System.out.println();
			  }
			  	System.out.println("----- ----- -----");
		  }
		  catch (SQLException e) {
		      System.out.println("SQL Exception occurred in getDebitcardTransactionHistoryByLastMonth method");
		      e.printStackTrace();
		    }  
	  }
}
