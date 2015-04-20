package framework.component;

import java.util.ArrayList;

public abstract class Customer implements ICustomer, IObserver {
	protected String name;
	protected String street;
	protected String city;
	protected String state;
	protected String zip;
	protected Email email;
	private String customerId;
	private ArrayList<Account> accountList;
	private NotificationRule rule;

	public abstract void addAccount(Account account);

	public abstract void removeAccount(Account account);

	public abstract void sendEmail(Email email);

	public void update(Entry entry) {

	}
}
