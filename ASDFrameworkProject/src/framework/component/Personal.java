package framework.component;

import java.util.Date;
import java.util.HashMap;

public class Personal extends Customer implements IPerson {
	private Date birthdate;
	public static String BIRTH_DATE_FIELD = "birth";
	double notifiAmount = 500;

	public Personal(HashMap<String, String> data) {
		super(data);

		birthdate = new Date(data.get(Personal.BIRTH_DATE_FIELD));

		notificationRule = new PersonalNotificationRule(notifiAmount);

		kindOfAccount = "personal";

	}

	@Override
	public Date getBirthday() {
		// TODO Auto-generated method stub
		return birthdate;
	}




}
