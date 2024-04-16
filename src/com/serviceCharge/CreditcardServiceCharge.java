package com.serviceCharge;

public class CreditcardServiceCharge extends ServiceCharge{

	
	public double getCreditcardServiceCharge(int initBanc) {
		if(initBanc <= 100000) {
			setServiceCharge(6.733);
		}
		else if(initBanc <= 500000) {
			setServiceCharge(12.43);
		}
		else {
			setServiceCharge(15.68);
		}
		return getServiceCharge();
	}

}
