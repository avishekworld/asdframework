package framework.component;

import java.util.ArrayList;

public abstract class Customer implements ICustomer, IObserver {
	public static int customerCounter;
	protected String name;
	protected String street;
	protected String city;
	protected String state;
	protected String zip;
	protected Email email;
	private String customerId;
	private ArrayList<Account> accountList;
	private NotificationRule rule;
	
	Customer(){
		customerCounter++;
		setCustomerId(getCustomerId() + customerCounter);
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
