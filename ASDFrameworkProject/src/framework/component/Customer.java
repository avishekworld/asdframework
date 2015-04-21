package framework.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class Customer implements ICustomer {
	public static int customerCounter;
	protected String name;
	protected String street;
	protected String city;
	protected String state;
	protected String zip;
	protected String email;
	private String customerId;
	protected ArrayList<Account> accountList;
	protected NotificationRule notificationRule;
	protected String kindOfAccount;
	public static String NAME_FIELD = "name";
	public static String STREET_FIELD = "street";
	public static String CITY_FIELD = "city";
	public static String STATE_FIELD = "state";
	public static String ZIP_FIELD = "zip";
	public static String EMAIL_FIELD = "email";

	public Customer(HashMap<String, String> Data) {
		customerCounter++;
		setCustomerId("" + customerCounter);

		accountList = new ArrayList<Account>();

		name = Data.get(Customer.NAME_FIELD);
		street = Data.get(Customer.STREET_FIELD);
		city = Data.get(Customer.CITY_FIELD);
		state = Data.get(Customer.STATE_FIELD);
		zip = Data.get(Customer.ZIP_FIELD);
		email = Data.get(Customer.EMAIL_FIELD);

	}

	public void addAccount(Account account)
	{
		account.setOwner(this);
		accountList.add(account);
	}

	public  void removeAccount(Account account)
	{
		accountList.remove(account);
	}

	public void sendEmail(Email email)
	{
		PopServer.sendEmail(email);
	}

	public abstract Account getLastAddedAccount();

	public void update(Entry entry) {
		
		String emailBody=entry.getEntryType()+" "+entry.getEntryAmount()+" Current Balance "+entry.getAfterBalance();
		
		sendEmail(new Email(email, "Bank Notification", emailBody));

	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public String getCustomerId() {
		return customerId;
	}

	private void setCustomerId(String customerId) {
		this.customerId = customerId;
	}



	public String getStreet() {
		return street;
	}



	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getEmail() {
		return email;
	}
	
	

	public String getKindOfAccount() {
		return kindOfAccount;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer: [ " + name + " , " + city + " ] ";
	}

	public NotificationRule getNotificationRule() {
		return notificationRule;
	}
	
	

}
