package com.card;

import java.time.LocalDate;

public class Debitcard extends Card implements DebitcardInterface{
	
	
	public Debitcard(int initBalance) {
		super.initBalance = initBalance;
	}
	
	
	@Override
	public int generateDebitcardCVV(int sessionID) {
		int CVV_Number =(int) (sessionID%1000);
		return CVV_Number;
	}
	
	
	@Override
	public void createDebitcard(int sessionID) {
		String displayName = getNameforCreatingCard();
		int password = getATMPin();
		LocalDate expiryDate = getExpiryDate();
		int cvv = generateDebitcardCVV(sessionID);
		int initBalance = getInitBalance();
		DebitcardDTO debitcardDTO = new DebitcardDTO();
		debitcardDTO.setCustomerID(sessionID);
		debitcardDTO.setName(displayName);
		debitcardDTO.setPassword(password);
		debitcardDTO.setExpirydate(expiryDate);
		debitcardDTO.setCvv(cvv);
		debitcardDTO.setInitBalance(initBalance);
		CardDAO cardDAO = new CardDAO();
		boolean isCardCreated = cardDAO.storeDebitcardDetails(debitcardDTO);
		if(isCardCreated) {
			System.out.println("\n╔═════════════════════════════════╗\n" +
								 "║ Debitcard successfully created! ║\n" +
								 "╚═════════════════════════════════╝\n");

		}
		else {
			System.out.println("\n╔════════════════════════════════╗\n" +
								 "║   Unable to create Debitcard!  ║\n" +
								 "╚════════════════════════════════╝\n");
		}
	}
	
	

	
	
}

