package framework.component;

import java.util.Date;
import java.util.HashMap;

public class Personal extends Customer implements IPerson {
	private Date birthdate;
	public static String BIRTH_DATE_FIELD = "birth";

	public Personal(HashMap<String, String> data) {
		super(data);

		birthdate=new Date(data.get(Personal.BIRTH_DATE_FIELD));
		
		notificationRule=new PersonalNotificationRule();
		
		kindOfAccount="personal";

	}

	@Override
	public Date getBirthday() {
		// TODO Auto-generated method stub
		return birthdate;
	}



	@Override
	public void sendEmail(Email email) {
		// TODO Auto-generated method stub

	}

	public Account getLastAddedAccount() {
		return super.accountList.get(super.accountList.size() - 1);
	}

	public String getCustomerType() {
		return "P";
	}
}
