package framework.component;

public class Company extends Customer implements ICompany {
	protected int noOfEmployee;

	public int getNoOfEmployee() {
		return 0;
	}

	public void doDebit(double amount) {

	}

	public void doCredit(double amount) {

	}

	public void addInterest() {

	}

	@Override
	public void sendEmail(Email email) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAccount(Account account) {
		// TODO Auto-generated method stub

	}
}