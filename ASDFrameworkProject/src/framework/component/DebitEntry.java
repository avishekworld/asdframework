package framework.component;

public class DebitEntry extends TransactionEntry {

	DebitEntry(double theBalance, double theAmount, String theIssuerName) {
		super("Debit", theBalance, theAmount, theIssuerName);
		// TODO Auto-generated constructor stub
	}

	public double getNewAmount() {
		afterBalance = beforeBalance - getEntryAmount();
		return afterBalance;
	}
}
