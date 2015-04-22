package framework.component;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Customer implements ICustomer {
	public static int customerCounter;
	protected String name;
	protected String street;
	protected String city;
	protected String state;
	protected String zip;
	protected String email;
	private String customerId;
	protected ArrayList<IAccount> accountList;
	protected NotificationRule notificationRule;
	protected String customerType;
	public static String NAME_FIELD = "name";
	public static String STREET_FIELD = "street";
	public static String CITY_FIELD = "city";
	public static String STATE_FIELD = "state";
	public static String ZIP_FIELD = "zip";
	public static String EMAIL_FIELD = "email";

	public Customer(HashMap<String, String> Data) {
		
		customerCounter++;
		
		customerId=customerCounter+"";

		accountList = new ArrayList<IAccount>();

		name = Data.get(Customer.NAME_FIELD);
		street = Data.get(Customer.STREET_FIELD);
		city = Data.get(Customer.CITY_FIELD);
		state = Data.get(Customer.STATE_FIELD);
		zip = Data.get(Customer.ZIP_FIELD);
		email = Data.get(Customer.EMAIL_FIELD);

	}

	public void addAccount(IAccount account) {
		account.setOwner(this);
		accountList.add(account);
	}

	public void removeAccount(IAccount account) {
		accountList.remove(account);
	}

	public void sendEmail(Email email) {
		PopServer.sendEmail(email);
	}

	public IAccount getLastAddedAccount() {
		return accountList.get(accountList.size() - 1);
	}
	
public void update(ITransactionEntry transactionEntry) {
		

		String emailBody=transactionEntry.getEntryType()+" "+transactionEntry.getEntryAmount()+" Current Balance "+transactionEntry.getNewBalance();

		
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
	
	

	public String getCustomerType() {
		return customerType;
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

	
