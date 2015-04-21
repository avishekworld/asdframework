package framework.component;

import java.util.Calendar;
import java.util.Date;

public abstract class Entry {
	private Date date;
	private double beforeBalance;
	private String IssuerName;
	private Double afterBalance;
	private double amount;
	private String type;

	Entry(String entryType, double theBalance, double theAmount,
			String theIssuerName) {
		type = entryType;
		date = Calendar.getInstance().getTime();
		IssuerName = theIssuerName;
		beforeBalance = theBalance;
		amount = theAmount;
		afterBalance = beforeBalance + amount;
	}

	public double getNewAmount() {
		return afterBalance;
	}

	public double getBeforBalance() {
		return 0;
	}

	public double getAfterBalance() {
		return 0;
	}
}
