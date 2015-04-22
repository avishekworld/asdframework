package framework.component;

import java.util.Calendar;
import java.util.Date;

public abstract class TransactionEntry implements ITransactionEntry{
	private Date date;
	protected double previousBalance;
	private String issuerName;
	protected double newBalance;
	protected double amount;
	private String entryName;

	TransactionEntry(String entryType, double theBalance, double theAmount,
			String theIssuerName) {
		this.entryName=entryType;
		date=Calendar.getInstance().getTime();
		issuerName = theIssuerName;
		previousBalance = theBalance;
		amount=theAmount;
		
		updateNewBalance();

	}

	protected abstract void updateNewBalance();

	public double getPreviousBalance() {
		return previousBalance;
	}

	public double getNewBalance() {
		return newBalance;
	}

	public Date getDate() {
		return date;
	}

	public String getEntryType() {
		return entryName;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ " + date.toString() + "\t " + previousBalance + "\t "
				+ issuerName + "\t " + entryName + "\t " + amount + "\t "
				+ newBalance + " ]";
	}

	public double getEntryAmount() {
		return amount;
	}
}
