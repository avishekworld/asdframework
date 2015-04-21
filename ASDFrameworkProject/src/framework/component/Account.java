package framework.component;


import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Account extends Subject {
	protected Type accountType;
	private double accountBalance;
	private Customer owner;
	private String accountNumber;
	public List<Entry> transactionEntry;
	public Date accountOpenDate;
	
	public static String ACC_NUM_FIELD="account no";
	
	public Account(HashMap<String, String> data) {
		
		accountNumber=data.get(Account.ACC_NUM_FIELD);
		transactionEntry = new LinkedList<Entry>();
	}

	public void doDebit(double amount)
	{
		
	}

	public void doCredit(double amount)
	{
		
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

	public void generateReport(Date date1, Date date2, IReport reportType) {

	}

	public double getTotalDebitAmount(Date date1, Date date2) {
		return (Double) null;

	}

	public double getTotalCreditAmount(Date date1, Date date2) {
		return (Double) null;
	}
}
