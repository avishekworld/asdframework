package framework.component;

public class DebitEntry extends Entry {

	DebitEntry(double theBalance, double theAmount, String theIssuerName) {
		super("DebitEntry", theBalance, theAmount, theIssuerName);
		// TODO Auto-generated constructor stub
	}

	public double getNewAmount() {
		return super.getNewAmount();
	}
}
