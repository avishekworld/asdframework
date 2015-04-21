package framework.component;

import java.util.HashMap;

public class Company extends Customer implements ICompany {

	protected int noOfEmployee;
	public static String NO_OF_EMPLOYEE_FIELD = "no_of_employee";

	public Company(HashMap<String, String> data) {
		super(data);
		noOfEmployee = Integer.parseInt(data.get(Company.NO_OF_EMPLOYEE_FIELD));

	}

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