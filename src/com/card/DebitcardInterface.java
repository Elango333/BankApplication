package com.card;

public interface DebitcardInterface {
	public int generateDebitcardCVV(int sessionID);
	public void createDebitcard(int sessionID);
}
