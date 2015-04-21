package framework.component;

import java.util.ArrayList;

public abstract class Customer implements ICustomer, IObserver {
	public static int customerCounter;
	protected String name;
	protected String street;
	protected String city;
	protected String state;
	protected String zip;
	protected String email;
	private String customerId;
	private ArrayList<Account> accountList;
	private NotificationRule rule;

	public Customer(HashMap<String, String> Data)
	{
		customerCounter++;
		setCustomerId(""+customerCounter);
		
		name=Data.get(Customer.NAME_FIELD);
		street=Data.get(Customer.STREET_FIELD);
		city=Data.get(Customer.CITY_FIELD);
		state=Data.get(Customer.STATE_FIELD);
		zip=Data.get(Customer.ZIP_FIELD);
		email=Data.get(Customer.EMAIL_FIELD);

	}

	public abstract void addAccount(Account account);

	public abstract void removeAccount(Account account);

	public abstract void sendEmail(Email email);

	public void update(Entry entry) {

	}

	public String getCustomerId() {
		return customerId;
	}

	private void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
