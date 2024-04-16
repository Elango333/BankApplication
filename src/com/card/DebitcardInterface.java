package com.card;

public interface DebitcardInterface {
	public int generateDebitcardCVV(int sessionID);
	public long createDebitcard(int sessionID);
}
