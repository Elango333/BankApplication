package com.card;

import java.time.LocalDate;

import com.serviceCharge.CreditcardServiceCharge;

public class Creditcard extends Card implements CreditcardInterface{
	
	public Creditcard(int initBalance) {
		super.initBalance = initBalance;
	}		
	
	public int generateCreditcardCVV(int sessionID) {
		int CVV_Number =(int) (sessionID%1000);
		return CVV_Number;
	}
	

	@Override
	public void createCreditcard(int sessionID) {
		String displayName = getNameforCreatingCard();
		int password = getATMPin();
		LocalDate expiryDate = getExpiryDate();
		int cvv = generateCreditcardCVV(sessionID);
		int initBalance = getInitBalance();
		CreditcardServiceCharge serviceCharge = new CreditcardServiceCharge();
		int serviceChargePerc = serviceCharge.getCreditcardServiceCharge(initBalance);
		CreditcardDTO creditcardDTO = new CreditcardDTO();
		creditcardDTO.setCustomerID(sessionID);
		creditcardDTO.setName(displayName);
		creditcardDTO.setPassword(password);
		creditcardDTO.setExpirydate(expiryDate);
		creditcardDTO.setCvv(cvv);
		creditcardDTO.setInitBalance(initBalance);
		creditcardDTO.setServiceChargePerc(serviceChargePerc);
		CardDAO cardDAO = new CardDAO();
		boolean isCardCreated = cardDAO.storeCreditcardDetails(creditcardDTO);
		if(isCardCreated) {
			System.out.println("\n╔══════════════════════════════════╗\n" +
								 "║ Creditcard successfully created! ║\n" +
								 "╚══════════════════════════════════╝\n");

		}
		else {
			System.out.println("\n╔═════════════════════════════════╗\n" +
								 "║   Unable to create Creditcard!  ║\n" +
								 "╚═════════════════════════════════╝\n");
		}
	}
	 
}
