package framework.component;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Account implements IAccount{
	public static int accountCounter = 2000;
	protected AccountType accountType;
	private double accountBalance;
	private ICustomer owner;
	private String accountNumber;
	public List<ITransactionEntry> transactionEntry;
	public Date accountOpenDate;

	public static String ACC_NUM_FIELD = "accountno";
	public static String ACC_TYPE_FIELD = "accounttype";

	public Account(HashMap<String, String> data, AccountType accountType) {
		transactionEntry = new LinkedList<ITransactionEntry>();

		accountCounter++;
		setAccountNumber("" + accountCounter);

		accountNumber = data.get(Account.ACC_NUM_FIELD);
		transactionEntry = new LinkedList<ITransactionEntry>();

		this.accountType = accountType;

		accountOpenDate = new Date();
		// accountCounter++;
		// setAccountNumber("" + accountCounter);
	}

	public void doDebit(double amount) {
		ITransactionEntry newEntry = new DebitEntry(getCurrentBalance(), amount,
				getAccountNumber());

		if(accountType.isTransactionValidate(newEntry))
		{
			accountBalance = newEntry.getNewBalance();

			transactionEntry.add(newEntry);

			NotificationRule notificationRule = owner.getNotificationRule();

			if (notificationRule.ruleMatch(newEntry)) {
				owner.update(newEntry);
			}
		}
		else 
		{
			JOptionPane.showMessageDialog(null,newEntry.getEntryType()+"  is not allwed as max transaction limit "+accountType.getMaxTransactionLimit()+" and lowest amount allowed is "+accountType.getLowestBalanceAllowed());

		}
		

	}

	public void doCredit(Double amount) {
		TransactionEntry newEntry = new CreditEntry(getCurrentBalance(), amount,
				getAccountNumber());

		accountBalance = newEntry.getNewBalance();

		transactionEntry.add(newEntry);

		NotificationRule notificationRule = owner.getNotificationRule();

		if (notificationRule.ruleMatch(newEntry)) {
			owner.update(newEntry);
		}
	}

	public void addInterest() {
		TransactionEntry newEntry = new CreditEntry(getCurrentBalance(),
				(accountType.getInterestRate()/100) * getCurrentBalance(),
				"Add Interest");
		accountBalance = newEntry.getNewBalance();
		transactionEntry.add(newEntry);
	}

	public double getCurrentBalance() {
		return accountBalance;
	}

	public void notifyCustomer(TransactionEntry transactionEntry) {
		System.out.println(" Account " + getAccountNumber()
				+ " : balance is negative: $" + getCurrentBalance() + " !"
				+ "Warning: negative balance");
	}

	public void generateReport(Date date1, Date date2, IReport reportType) {
		List<ITransactionEntry> reportEntryList = new LinkedList<ITransactionEntry>();
		date1.setHours(0);
		date1.setMinutes(0);
		date1.setSeconds(0);
		date2.setHours(23);
		date2.setMinutes(59);
		date2.setSeconds(59);
		for (ITransactionEntry e : transactionEntry) {
			Date ev = e.getDate();
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
		for (ITransactionEntry e : transactionEntry) {
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
		for (ITransactionEntry e : transactionEntry) {
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

	public ICustomer getOwner() {
		return owner;
	}

	public AccountType getAccountType() {
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

	public void setOwner(ICustomer owner) {
		this.owner = owner;
	}

}
