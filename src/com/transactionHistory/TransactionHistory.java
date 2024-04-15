package com.transactionHistory;

public class TransactionHistory {

	public void showFeatures(int sessionID, long debitcardNumber) {
		 System.out.println("\n" +
			      "╔═══════════════════════════════════════════════════╗\n" +
			      "║                                                   ║\n" +
			      "║   View today transactions            - Press (1)  ║\n" +
			      "║                                                   ║\n" +
			      "║   View last 7 days transactions      - Press (2)  ║\n" +
			      "║                                                   ║\n" +
			      "║   View last 30 days transactions     - Press (3)  ║\n" +
			      "║                                                   ║\n" +
			      "║   Back                               - Press (4)  ║\n" +
			      "║                                                   ║\n" +
			      "╚═══════════════════════════════════════════════════╝\n\n");
	}
}
