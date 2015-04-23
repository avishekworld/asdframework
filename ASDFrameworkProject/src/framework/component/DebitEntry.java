package framework.component;

public class DebitEntry extends TransactionEntry {

	public DebitEntry(double theBalance, double theAmount, String theIssuerName) {
		super("Debit", theBalance, theAmount, theIssuerName);
		// TODO Auto-generated constructor stub
	}

	public void updateNewBalance() {
		
		newBalance = previousBalance- amount;
		
	}

}
