package framework.component;

public class CreditEntry extends Entry {

	CreditEntry(double theBalance, double theAmount, String theIssuerName) {
		super("CreditEntry", theBalance, theAmount, theIssuerName);
		// TODO Auto-generated constructor stub
	}

	public double getNewAmount() {
		return super.getNewAmount();
	}
}
