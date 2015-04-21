package framework.component;


import java.util.Date;
import java.util.HashMap;

public class Personal extends Customer implements IPerson {
	private Date birthdate;
	public static String BIRTH_DATE_FIELD="birth";
	
	
	public Personal(HashMap<String, String> data)
	{
		super(data);
		
		birthdate=new Date(data.get(Personal.BIRTH_DATE_FIELD));
		
	}
	
	@Override
	public Date getBirthday() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAccount(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendEmail(Email email) {
		// TODO Auto-generated method stub
		
		

	}

}
