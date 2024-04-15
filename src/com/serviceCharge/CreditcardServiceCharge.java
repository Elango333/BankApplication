package com.serviceCharge;

public class CreditcardServiceCharge extends ServiceCharge{
	public static int serviceCharge;
	
	public int getCreditcardServiceCharge(int initBanc) {
		if(initBanc <= 100000) {
			serviceCharge = 10;
		}
		else if(initBanc <= 500000) {
			serviceCharge = 13;
		}
		else {
			serviceCharge = 15;
		}
		return serviceCharge;
	}

}
