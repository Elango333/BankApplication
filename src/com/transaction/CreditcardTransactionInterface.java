package com.transaction;

public interface CreditcardTransactionInterface{
	public void showCreditcardFeature(int sessionID, long creditcardNumber);
	public int calculateRepayableAmount(int debitAmount, int serviceCharge);
}
