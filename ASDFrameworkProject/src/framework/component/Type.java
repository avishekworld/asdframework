package framework.component;






public abstract class Type
{
	private String typeName;
	private double interestRate;
	private double maxTransactionLimit;
	public double getInterestRate(){
		return interestRate;
	}
	
	public double getMaxTransactionLimit(){
		return maxTransactionLimit;
	}
}
