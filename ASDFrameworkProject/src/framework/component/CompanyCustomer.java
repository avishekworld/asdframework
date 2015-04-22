package framework.component;

import java.util.HashMap;

public class CompanyCustomer extends Customer implements ICompany {

	protected int noOfEmployee;
	public static String NO_OF_EMPLOYEE_FIELD = "no_of_employee";

	public CompanyCustomer(HashMap<String, String> data) {
		super(data);
		noOfEmployee = Integer.parseInt(data.get(CompanyCustomer.NO_OF_EMPLOYEE_FIELD));
		notificationRule = new CompanyNotificationRule();
		customerType = "company";
	}

	public int getNoOfEmployee() {
		return noOfEmployee;
	}


}
