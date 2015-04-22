package framework.component;

public abstract class AccountType {
	private String typeName;
	private double interestRate;
	private double maxTransactionLimit;
	private double lowestBalanceAllowed;

	

	public AccountType(String typeName, double interestRate, double maxTransactionLimit,double lb) {
		this.typeName = typeName;
		this.interestRate = interestRate;
		this.maxTransactionLimit = maxTransactionLimit;
		lowestBalanceAllowed=lb;
	}



	public double getInterestRate() {

		return interestRate;
	}

	public double getMaxTransactionLimit() {
		return maxTransactionLimit;
	}

	public String getTypeName() {
		return typeName;
	}



	public double getLowestBalanceAllowed() {
		return lowestBalanceAllowed;
	}



	public void setLowestBalanceAllowed(double lowestBalanceAllowed) {
		this.lowestBalanceAllowed = lowestBalanceAllowed;
	}
	
	public boolean isTransactionValidate(TransactionEntry transactionEntry)
	{
		boolean shouldAllowed=true;
		
		if(transactionEntry.amount>maxTransactionLimit)
		{
			shouldAllowed= false;
		}
		else if(transactionEntry.afterBalance<lowestBalanceAllowed)
		{
			shouldAllowed=false;
		}
		
		return shouldAllowed;
	}
	
}
