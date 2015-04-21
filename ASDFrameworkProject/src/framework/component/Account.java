package framework.component;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class Account extends Subject {
	protected Type accountType;
	private double accountBalance;
	private Customer owner;
	private int accountNumber;
	public List<Entry> transactionEntry;
	public Date accountOpenDate;

	public abstract void doDebit(Double amount);

	public abstract void doCredit(Double amount);

	public Account() {
		// TODO Auto-generated constructor stub
		transactionEntry = new LinkedList<Entry>();
	}

	public void addInterest() {
		Entry newEntry = new CreditEntry(getCurrentBalance(),
				accountType.getInterestRate() * getCurrentBalance(),
				"Add Interest");
		accountBalance = newEntry.getNewAmount();
		transactionEntry.add(newEntry);
	}

	public Double getCurrentBalance() {
		return accountBalance;
	}

	public void notifyCustomer(Entry entry) {

	}

	public void generateReport(Date date1, Date date2) {

	}

	public double getTotalDebitAmount(Date date1, Date date2) {
		return (Double) null;

	}

	public double getTotalCreditAmount(Date date1, Date date2) {
		return (Double) null;
	}
}
