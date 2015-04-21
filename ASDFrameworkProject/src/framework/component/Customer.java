package framework.component;


import java.util.ArrayList;
import java.util.HashMap;

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
	
	public static String NAME_FIELD="name";
	public static String STREET_FIELD="street";
	public static String CITY_FIELD="city";
	public static String STATE_FIELD="state";
	public static String ZIP_FIELD="zip";
	public static String EMAIL_FIELD="email";
	
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
