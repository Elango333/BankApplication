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
	public long createDebitcard(int sessionID) {
		long debitcardNumber = 0;
		String displayName = getNameforCreatingCard();
//		int password = getATMPin();
		LocalDate validFromDate = getValidFromDate();
		LocalDate validToDate = getValidToDate();
		int cvv = generateDebitcardCVV(sessionID);
		int initBalance = getInitBalance();
		DebitcardDTO debitcardDTO = new DebitcardDTO();
		debitcardDTO.setCustomerID(sessionID);
		debitcardDTO.setName(displayName);
//		debitcardDTO.setPassword(password);
		debitcardDTO.setValidFrom(validFromDate);
		debitcardDTO.setValidTo(validToDate);
		debitcardDTO.setCvv(cvv);
		debitcardDTO.setInitBalance(initBalance);
		CardDAO cardDAO = new CardDAO();
		debitcardNumber = cardDAO.storeDebitcardDetails(debitcardDTO);
		if(debitcardNumber > 0) {
			System.out.println("\n╔═════════════════════════════════╗\n" +
								 "║ Debitcard successfully created! ║\n" +
								 "╚═════════════════════════════════╝\n\n");
			System.out.println("Your Debitcard number : " + debitcardNumber);

		}
		else {
			System.out.println("\n╔════════════════════════════════╗\n" +
								 "║   Unable to create Debitcard!  ║\n" +
								 "╚════════════════════════════════╝\n");
		}
		return debitcardNumber;
	}
}

