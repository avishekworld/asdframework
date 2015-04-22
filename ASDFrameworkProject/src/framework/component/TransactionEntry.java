package framework.component;

import java.util.Calendar;
import java.util.Date;

public abstract class TransactionEntry {
	private Date date;
	protected double beforeBalance;
	private String issuerName;
	protected double afterBalance;
	protected double amount;
	private String entryType;

	TransactionEntry(String entryType, double theBalance, double theAmount,
			String theIssuerName) {
		this.entryType=entryType;
		date=Calendar.getInstance().getTime();
		issuerName = theIssuerName;
		beforeBalance = theBalance;
		amount=theAmount;

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


	public double getEntryAmount() {
		return amount;
	}

	public String getEntryType() {
		return entryType;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ " + date.toString() + "\t " + beforeBalance + "\t "
				+ issuerName + "\t " + entryType + "\t " + amount + "\t "
				+ getNewAmount() + " ]";
	}
}
