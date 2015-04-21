package framework.component;

public abstract class Type {
	private String typeName;

	public String getTypeName() {
		return typeName;
	}

	private double interestRate;
	private double maxTransactionLimit;

	Type(String name) {
		typeName = name;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public double getMaxTransactionLimit() {
		return maxTransactionLimit;
	}
}
