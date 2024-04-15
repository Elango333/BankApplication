package com.utils;

public class ConstantFile {
	public static String insert_query_for_register = "insert into Customer (Name, Password, MobileNumber) values (?, ?, ?)";
	public static String select_query_for_isAccountAlreadyExists = "select Password FROM Customer WHERE Name = ?";
	public static String select_query_for_sessionID = "select CustomerID from Customer where Name = ?";
	public static String insert_query_for_creditcardDetails = "insert into Creditcard (CustomerID, CurrentBalance, CVV, Password, CardHolderName, ExpiryDate, ServiceChargePerc, RepayAmount) values (?, ?, ?, ?, ?, ?, ?, ?)";
	public static String insert_query_for_debitcardDetails = "insert into Debitcard (CustomerID, CurrentBalance, CVV, Password, CardHolderName, ExpiryDate) values (?, ?, ?, ?, ?, ?)";
	public static String select_query_for_getDebitcardBalanceAmount = "select CurrentBalance from Debitcard where CustomerID = ?";
	public static String update_query_for_DebitcardPayment = "update Debitcard set CurrentBalance = ? where CustomerID = ?";
	public static String select_query_for_getCreditcardBalanceAmount = "select CurrentBalance from Creditcard where CreditcardNumber = ?";
	public static String select_query_for_getCreditcardRepayabaleAmount = "select RepayAmount from Creditcard where CreditcardNumber = ?";
	public static String select_query_for_getServiceChargePercn = "select ServiceChargePerc from Creditcard where CreditcardNumber = ?";
	public static String update_query_for_CreditcardRepayableAmount = "update Creditcard set RepayAmount = ? where CustomerID = ?";
	public static String insert_query_for_debitcardTransactionHistory = "insert into Debitcard_TransactionsHistory (CustomerID, DebitcardNumber, TransactionType, Date) values (?, ?, ?, ?)";
	public static String insert_query_for_creditcardTransactionHistory = "insert into Creditcard_TransactionsHistory (CustomerID, CreditcardNumber, TransactionType, Date) values (?, ?, ?, ?)";
	public static String select_query_for_debitcardNumber = "select DebitcardNumber from Debitcard where CustomerID = ?";
	public static String select_query_for_creditcardNumber = "select CreditcardNumber from Creditcard where CustomerID = ?";
	public static String select_query_for_getDebitcardTransactionHistoryByCurrentDate = "select TransactionType, Date from Debitcard_TransactionsHistory where DebitcardNumber = ? and Date = ?";
	public static String select_query_for_getCreditcardTransactionHistoryByCurrentDate = "select TransactionType, Date from Creditcard_TransactionsHistory where CreditcardNumber = ? and Date = ?";
	public static String select_query_for_getDebitcardTransactionHistoryByLastweek = "select TransactionType, Date from Debitcard_TransactionsHistory where DebitcardNumber = ? and Date >= ? and Date <= ?";
	public static String select_query_for_getCreditcardTransactionHistoryByLastweek = "select TransactionType, Date from Creditcard_TransactionsHistory where CreditcardNumber = ? and Date >= ? and Date <= ?";
	public static String select_query_for_getDebitcardTransactionHistoryByLastmonth = "select TransactionType, Date from Debitcard_TransactionsHistory where DebitcardNumber = ? and Date >= ? and Date <= ?";
	public static String select_query_for_getCreditcardTransactionHistoryByLastmonth = "select TransactionType, Date from Creditcard_TransactionsHistory where CreditcardNumber = ? and Date >= ? and Date <= ?";
	public static String update_query_for_CreditcardPayment = "update Creditcard set CurrentBalance = ? where CustomerID = ?";
	public static String select_query_for_getDebitcardDetails = "select DebitcardNumber, CVV, Password, CardHolderName, ExpiryDate from Debitcard where DebitcardNumber = ?";
	public static String select_query_for_getCreditcardDetails = "select CreditcardNumber, CVV, Password, CardHolderName, ExpiryDate from Creditcard where CreditcardNumber = ?";
	
	
}
