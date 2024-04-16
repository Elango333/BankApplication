package com.card;

import java.time.LocalDate;

import com.serviceCharge.CreditcardServiceCharge;

public class Creditcard extends Card implements CreditcardInterface{
	
	public Creditcard(int initBalance) {
		super.initBalance = initBalance;
	}		
	
	public int generateCreditcardCVV(int sessionID) {
		cvv = (int) (sessionID%1000);
		return cvv;
	}
	
	@Override
	public long createCreditcard(int sessionID) {
		long debitcardNumber = 0;
		String displayName = getNameforCreatingCard();
//		int password = getATMPin();
		LocalDate validFromDate = getValidFromDate();
		LocalDate validToDate = getValidToDate();
		int cvv = generateCreditcardCVV(sessionID);
		int initBalance = getInitBalance();
		CreditcardServiceCharge serviceCharge = new CreditcardServiceCharge();
		double serviceChargePerc = serviceCharge.getCreditcardServiceCharge(initBalance);
		CreditcardDTO creditcardDTO = new CreditcardDTO();
		creditcardDTO.setCustomerID(sessionID);
		creditcardDTO.setName(displayName);
//		creditcardDTO.setPassword(password);
		creditcardDTO.setValidFrom(validFromDate);
		creditcardDTO.setValidTo(validToDate);
		creditcardDTO.setCvv(cvv);
		creditcardDTO.setInitBalance(initBalance);
		creditcardDTO.setServiceChargePerc(serviceChargePerc);
		CardDAO cardDAO = new CardDAO();
		debitcardNumber = cardDAO.storeCreditcardDetails(creditcardDTO);
		if(debitcardNumber > 0) {
			System.out.println("\n╔══════════════════════════════════╗\n" +
								 "║ Creditcard successfully created! ║\n" +
								 "╚══════════════════════════════════╝\n\n");
			System.out.println("Your Creditcard number : "+ debitcardNumber);

		}
		else {
			System.out.println("\n╔═════════════════════════════════╗\n" +
								 "║   Unable to create Creditcard!  ║\n" +
								 "╚═════════════════════════════════╝\n");
		}
		return debitcardNumber;
	}
	 
}
