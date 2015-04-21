package framework.model;

import java.util.HashMap;
import java.util.Iterator;

import framework.component.Account;
import framework.component.Customer;

public class DefaultModel implements IModel {
	public HashMap<String, Customer> customerList;
	public HashMap<String, Account> accountList;

	public DefaultModel() {
		// TODO Auto-generated constructor stub
		customerList = new HashMap<String, Customer>();
		accountList = new HashMap<String, Account>();
	}

	public Customer getCustomer(String customerId) {
		return customerList.get(customerId);
	}

	public Account getAccount(String accountId) {
		return accountList.get(accountId);
	}

	public void addCustomer(Customer customer) {
		customerList.put(customer.getCustomerId(), customer);
	}

	public void addInterest() {
		Iterator i = accountList.entrySet().iterator();
		while (i.hasNext()) {
			String key = i.next().toString();
			Account account = accountList.get(key);
			account.addInterest();
		}
	}

	public HashMap<String, Account> getAllAcounts() {
		return accountList;
	}

	@Override
	public HashMap<String, Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerList;
	}

}
