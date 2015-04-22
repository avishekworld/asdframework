package framework.component;

import java.util.Date;

public interface IAccount {
	
	public void doDebit(double amount);
	
	public void  doCredit(Double amount);
	
	public void addInterest();
	
	public double getCurrentBalance();
	
	public void notifyCustomer(TransactionEntry transactionEntry);
	
	public void generateReport(Date date1, Date date2, IReport reportType);
	
	public double getTotalDebitAmount(Date date1, Date date2);
	
	public double getTotalCreditAmount(Date date1, Date date2);
	
	public String getAccountNumber();
	
	public ICustomer getOwner();
	
	public void setOwner(ICustomer owner);
	
	public AccountType getAccountType();
	
	public double getAccountBalance();

}
