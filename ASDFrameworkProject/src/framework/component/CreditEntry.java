package framework.component;

public class CreditEntry extends TransactionEntry {

	CreditEntry(double theBalance, double theAmount, String theIssuerName) {
		super("Credit", theBalance, theAmount, theIssuerName);
		// TODO Auto-generated constructor stub
	}

	public void updateNewBalance() {
		newBalance = previousBalance + amount;
	}
}
