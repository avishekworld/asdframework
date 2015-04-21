package framework.component;

import java.util.Calendar;
import java.util.Date;

public abstract class Entry {
	private Date date;
	protected double beforeBalance;
	private String issuerName;
	protected Double afterBalance;
	protected double amount;
	private String type;

	Entry(String entryType, double theBalance, double theAmount,
			String theIssuerName) {
		setEntryType(entryType);
		setDate(Calendar.getInstance().getTime());
		issuerName = theIssuerName;
		beforeBalance = theBalance;
		setEntryAmount(theAmount);

	}

	public abstract double getNewAmount();

	public double getBeforBalance() {
		return beforeBalance;
	}

	public double getAfterBalance() {
		return afterBalance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getEntryAmount() {
		return amount;
	}

	public void setEntryAmount(double amount) {
		this.amount = amount;
	}

	public String getEntryType() {
		return type;
	}

	public void setEntryType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ " + date.toString() + "\t " + beforeBalance + "\t "
				+ issuerName + "\t " + type + "\t " + amount + "\t "
				+ getNewAmount() + " ]";
	}
}
