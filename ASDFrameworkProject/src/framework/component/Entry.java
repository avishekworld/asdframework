package framework.component;

import java.util.Date;

public abstract class Entry {
	private Date date;
	private double beforeBalance;
	private String IssuerName;
	private Double afterBalance;
	private double amount;
	private String type;

	public double getAmount() {
		return 0;
	}

	public double getBeforBalance() {
		return 0;
	}

	public double getAfterBalance() {
		return 0;
	}
}
