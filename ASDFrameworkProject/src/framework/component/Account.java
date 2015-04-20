




public abstract class Account extends Subject
{
	protected Type type;
	private double accountBalance;
	private Customer owner;
	private Object accountNumber;
	public ArrayList<Entry> transactionEntry;
	public Object accountOpenDate;
	public void submit(Object Command)
	{
	
	}
	
	public abstract void doDebit(Object Amount);
	
	public abstract void doCredit(Object Amount);
	
	public abstract void addInterest();
	
	public Double getCurrentBalance()
	{
	
	}
	
	public void notifyCustomer(Object Transaction)
	{
	
	}
	
	public void generateReport(Object Date1, Object Date2, Object IReport)
	{
	
	}
	
	public double getTotalDebitAmount(Object Date1, Object Date2)
	{
	
	}
	
	public double getTotalCreditAmount(Object Date1, Object Date2)
	{
	
	}
}
