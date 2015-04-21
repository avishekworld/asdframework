package framework.component;

public abstract class Type {
	private String typeName;
	private double interestRate;
	private double maxTransactionLimit;

	

	public Type(String typeName, double interestRate, double maxTransactionLimit) {
		this.typeName = typeName;
		this.interestRate = interestRate;
		this.maxTransactionLimit = maxTransactionLimit;
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
	
	
}
