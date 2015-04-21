package framework.component;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Account {
	public static int accountCounter = 2000;
	protected Type accountType;
	private double accountBalance;
	private Customer owner;
	private String accountNumber;
	public List<Entry> transactionEntry;
	public Date accountOpenDate;

	public static String ACC_NUM_FIELD = "accountno";
	public static String ACC_TYPE_FIELD = "accounttype";

	public Account(HashMap<String, String> data, Type type) {
		transactionEntry = new LinkedList<Entry>();

		accountCounter++;
		setAccountNumber("" + accountCounter);

		accountNumber = data.get(Account.ACC_NUM_FIELD);
		transactionEntry = new LinkedList<Entry>();

		accountType = type;

		accountOpenDate = new Date();
		// accountCounter++;
		// setAccountNumber("" + accountCounter);
	}

	public void doDebit(Double amount) {
		Entry newEntry = new DebitEntry(getCurrentBalance(), amount,
				getAccountNumber());

		accountBalance = newEntry.getNewAmount();

		transactionEntry.add(newEntry);

		NotificationRule notificationRule = owner.getNotificationRule();

		if (notificationRule.ruleMatch(newEntry)) {
			owner.update(newEntry);
		}

	}

	public void doCredit(Double amount) {
		Entry newEntry = new CreditEntry(getCurrentBalance(), amount,
				getAccountNumber());

		accountBalance = newEntry.getNewAmount();

		transactionEntry.add(newEntry);

		NotificationRule notificationRule = owner.getNotificationRule();

		if (notificationRule.ruleMatch(newEntry)) {
			owner.update(newEntry);
		}
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
		System.out.println(" Account " + getAccountNumber()
				+ " : balance is negative: $" + getCurrentBalance() + " !"
				+ "Warning: negative balance");
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
			Date ev=e.getDate();
			if ((date1.equals(e.getDate()) || date2.equals(e.getDate()))
					|| (date1.before(e.getDate()) && date2.after(e.getDate()))) {
				reportEntryList.add(e);
			}
		}// for

		reportType.Generate(getAccountNumber(), reportEntryList);
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

	public Customer getOwner() {
		return owner;
	}

	public Type getAccountType() {
		return accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return accountNumber + " -> " + accountBalance;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

}
