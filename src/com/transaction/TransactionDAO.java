package com.transaction;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.transactionHistory.TransactionHistoryDAO;
import com.utils.ConstantFile;
import com.utils.DatabaseConnection;

public class TransactionDAO {
		
	  private DatabaseConnection connection = DatabaseConnection.getInstance();
	  private Connection conn = connection.getConnection();
	  TransactionHistoryDAO transactionhistory = new TransactionHistoryDAO();
	  public int getDebitcardBalanceAmount(int sessionID, long debitcardNumber) {
		  int balanceAmount = 0;
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_getDebitcardBalanceAmount);
			  statement.setInt(1,  sessionID);
			  ResultSet resultset = statement.executeQuery();
			  if(resultset.next()) {
				  balanceAmount = resultset.getInt(1);
				  transactionhistory.updateDebitcardHistory(sessionID, debitcardNumber, "Balance checked");
			  }
		  }
		  catch (SQLException e) {
			  System.out.println("SQL Exception occurred in getDebitcardBalanceAmount");
		  }
		  return balanceAmount;
	  }
	  
	  public boolean debitcardDebitAmount(int amount, int sessionID, long debitcardNumber) {
		  boolean isDebited = false;
		  int checkMinimumBalance = getDebitcardBalanceAmount(sessionID, debitcardNumber);
		  if((checkMinimumBalance-amount) >= 0) {
			  try {
			      PreparedStatement statement = conn.prepareStatement(ConstantFile.update_query_for_DebitcardPayment);
			      statement.setInt(1, (getDebitcardBalanceAmount(sessionID, debitcardNumber)-amount));
			      statement.setInt(2, sessionID);
			      int rowsAffected = statement.executeUpdate();

			      if (rowsAffected > 0) {
			    	  transactionhistory.updateDebitcardHistory(sessionID, debitcardNumber, "Amount debited");
			    	  isDebited = true;
			      } 
			    } catch (SQLException e) {
			      System.out.println("SQL Exception occurred in debitcardPayAmount method");
			      e.printStackTrace();
			    } 
		  }
		  else {
			  isDebited = false;  
		  }
		  return isDebited;
	  }
	  
	  public boolean debitcardCreditAmount(int amount, int sessionID, long debitcardNumber) { 
		  boolean isCredited = false;
		  try {
		      PreparedStatement statement = conn.prepareStatement(ConstantFile.update_query_for_DebitcardPayment);
		      statement.setInt(1, (getDebitcardBalanceAmount(sessionID, debitcardNumber)+amount));
		      statement.setInt(2, sessionID);
		      int rowsAffected = statement.executeUpdate();

		      if (rowsAffected > 0) {
		    	  isCredited = true;
		    	  transactionhistory.updateDebitcardHistory(sessionID, debitcardNumber, "Amount credited");
		      } 
		    } catch (SQLException e) {
		      System.out.println("SQL Exception occurred in debitcardCreditAmount method");
		      e.printStackTrace();
		    } 
	  return isCredited;
	  }
	  
	  
	  
	  
	  //creditcard functions
	  public int getCreditcardBalanceAmount(int sessionID, long creditcardNumber) {
		  int balanceAmount = 0;
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_getCreditcardBalanceAmount);
			  statement.setLong(1,  creditcardNumber);
			  ResultSet resultset = statement.executeQuery();
			  if(resultset.next()) {
				  balanceAmount = resultset.getInt(1);
				  transactionhistory.updateCreditcardHistory(sessionID, creditcardNumber, "Balance checked");
			  }
		  }
		  catch (SQLException e) {
			  System.out.println("SQL Exception occurred in getCreditcardBalanceAmount");
		  }
		  return balanceAmount;
	  }
	  
	  
	  public boolean creditcardDebitAmount(int amount, int sessionID, long creditcardNumber) {
		  boolean isDebited = false;
		  int checkMinimumBalance = getCreditcardBalanceAmount(sessionID, creditcardNumber);
		  if((checkMinimumBalance-amount) >= 0) {
			  try {
			      PreparedStatement statement = conn.prepareStatement(ConstantFile.update_query_for_CreditcardPayment);
			      statement.setInt(1, (getCreditcardBalanceAmount(sessionID, creditcardNumber)-amount));
			      statement.setInt(2, sessionID);
			      int rowsAffected = statement.executeUpdate();

			      if (rowsAffected > 0) {
			    	  transactionhistory.updateCreditcardHistory(sessionID, creditcardNumber, "Amount debited");
			    	  isDebited = true;
			    	  PreparedStatement stmnt = conn.prepareStatement(ConstantFile.update_query_for_CreditcardRepayableAmount);
			    	  int repayableAmount = getCreditcardRepayableAmount(sessionID);
			    	  int loanAmount = repayableAmount + (amount + (amount/getServiceChargePercn(creditcardNumber)));
			    	  stmnt.setInt(1, loanAmount);
			    	  stmnt.setInt(2, sessionID);
			    	  stmnt.executeUpdate();
			      } 
			    } catch (SQLException e) {
			      System.out.println("SQL Exception occurred in creditcardDebitAmount method");
			      e.printStackTrace();
			    } 
		  }
		  else {
			  isDebited = false;  
		  }
		  return isDebited;
	  }
	  
	  
	  public int getCreditcardRepayableAmount(long creditcardNumber) {
		  int repayableAmount = 0;
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_getCreditcardRepayabaleAmount);
			  statement.setLong(1,  creditcardNumber);
			  ResultSet resultset = statement.executeQuery();
			  if(resultset.next()) {
				  repayableAmount = resultset.getInt(1);
			  }
		  }
		  catch (SQLException e) {
			  System.out.println("SQL Exception occurred in getCreditcardBalanceAmount");
		  }
		  return repayableAmount;
	  }
	  
	  public int getServiceChargePercn(long creditcardNumber) {
		  int serviceCharge = 0;
		  try {
			  PreparedStatement statement = conn.prepareStatement(ConstantFile.select_query_for_getServiceChargePercn);
			  statement.setLong(1,  creditcardNumber);
			  ResultSet resultset = statement.executeQuery();
			  if(resultset.next()) {
				  serviceCharge = resultset.getInt(1);
			  }
		  }
		  catch (SQLException e) {
			  System.out.println("SQL Exception occurred in getServiceChargePercn");
		  }
		  return serviceCharge; 
	  }
	  
	  public boolean creditcardCreditRepayableAmount(int amount, int sessionID, long creditcardNumber) {
		  boolean isCredited = false;
		  try {
		      PreparedStatement statement = conn.prepareStatement(ConstantFile.update_query_for_CreditcardRepayableAmount);
		      statement.setInt(1, (getCreditcardRepayableAmount(creditcardNumber)-amount));
		      statement.setInt(2, sessionID);
		      int rowsAffected = statement.executeUpdate();
		      if (rowsAffected > 0) {
		    	  isCredited = true;
		    	  transactionhistory.updateCreditcardHistory(sessionID, creditcardNumber, "Amount credited");
		      } 
		    } catch (SQLException e) {
		      System.out.println("SQL Exception occurred in creditcardCreditRepayableAmount method");
		      e.printStackTrace();
		    } 
	  return isCredited;
	  }
	  
	  
}
