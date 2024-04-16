package com.serviceCharge;

public class CreditcardServiceCharge extends ServiceCharge{
	public static double serviceCharge;
	
	public double getCreditcardServiceCharge(int initBanc) {
		if(initBanc <= 100000) {
			serviceCharge = 6.7333;
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
