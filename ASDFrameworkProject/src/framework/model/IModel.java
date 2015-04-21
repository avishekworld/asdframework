package framework.model;

import java.util.HashMap;

import framework.component.Account;
import framework.component.Customer;

public interface IModel {
	public Customer getCustomer(String customerId);

	public Account getAccount(String accountId);

	public void addCustomer(Customer customer);

	public void addInterest();

	public HashMap<String, Account> getAllAcounts();
}
