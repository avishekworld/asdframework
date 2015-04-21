package framework.component;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Account extends Subject {
	public static int accountCounter = 2000;
	protected Type accountType;
	private double accountBalance;
	private Customer owner;
	private String accountNumber;
	public List<Entry> transactionEntry;
	public Date accountOpenDate;

	public static String ACC_NUM_FIELD="account no";
	
	public Account() {
		// TODO Auto-generated constructor stub
		transactionEntry = new LinkedList<Entry>();

		accountCounter++;
		setAccountNumber("" + accountCounter);
	}
	
	public Account(HashMap<String, String> data) {
		
		accountNumber=data.get(Account.ACC_NUM_FIELD);
		transactionEntry = new LinkedList<Entry>();
	}
	
	public void doDebit(Double amount) {
		Entry newEntry = new DebitEntry(getCurrentBalance(), amount,
				getAccountNumber());
		accountBalance = newEntry.getNewAmount();
		transactionEntry.add(newEntry);
	}

	public void doCredit(Double amount) {
		Entry newEntry = new CreditEntry(getCurrentBalance(), amount,
				getAccountNumber());
		accountBalance = newEntry.getNewAmount();
		transactionEntry.add(newEntry);
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
		List<Entry> reportEntryList = new LinkedList<Entry>();
		date1.setHours(0);
		date1.setMinutes(0);
		date1.setSeconds(0);
		date2.setHours(23);
		date2.setMinutes(59);
		date2.setSeconds(59);
		for (Entry e : transactionEntry) {
			if ((date1.equals(e.getDate()) && date2.equals(e.getDate()))
					|| (date1.after(e.getDate()) && date2.before(e.getDate()))) {
				reportEntryList.add(e);
			}
		}// for

		reportType.Generate(reportEntryList);
	}

	public double getTotalDebitAmount(Date date1, Date date2) {
		double debitAmount = 0;
		date1.setHours(0);
		date1.setMinutes(0);
		date1.setSeconds(0);
		date2.setHours(23);
		date2.setMinutes(59);
		date2.setSeconds(59);
		for (Entry e : transactionEntry) {
			if ((date1.equals(e.getDate()) && date2.equals(e.getDate()))
					|| (date1.after(e.getDate()) && date2.before(e.getDate()))) {

				if (e.getEntryType().equals("DebitEntry")) {
					debitAmount += e.getEntryAmount();
				}
			}
		}// for

		return debitAmount;

	}

	public double getTotalCreditAmount(Date date1, Date date2) {
		double crebitAmount = 0;
		date1.setHours(0);
		date1.setMinutes(0);
		date1.setSeconds(0);
		date2.setHours(23);
		date2.setMinutes(59);
		date2.setSeconds(59);
		for (Entry e : transactionEntry) {
			if ((date1.equals(e.getDate()) && date2.equals(e.getDate()))
					|| (date1.after(e.getDate()) && date2.before(e.getDate()))) {

				if (e.getEntryType().equals("CreditEntry")) {
					crebitAmount += e.getEntryAmount();
				}
			}
		}// for

		return crebitAmount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
