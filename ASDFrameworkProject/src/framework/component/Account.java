package framework.component;

import java.util.ArrayList;
import java.util.Date;

public abstract class Account extends Subject {
	protected Type accountType;
	private double accountBalance;
	private Customer owner;
	private int accountNumber;
	public ArrayList<Entry> transactionEntry;
	public Date accountOpenDate;

	public abstract void doDebit(Double amount);

	public abstract void doCredit(Double amount);

	public abstract void addInterest();

	public Double getCurrentBalance() {
		return accountBalance;
	}

	public void notifyCustomer(Entry entry) {

	}

	public void generateReport(Date date1, Date date2, IReport reporyType) {

	}

	public double getTotalDebitAmount(Date date1, Date date2) {
		return (Double) null;

	}

	public double getTotalCreditAmount(Date date1, Date date2) {
		return (Double) null;
	}
}
