package framework.model;


import java.util.*;

import framework.component.Account;
import framework.component.Customer;

public interface IModel {
	public Customer getCustomer(String customerId);

	public Account getAccount(String accountId);

	public void addCustomer(Customer customer);

	public void addAccount(Account account);

	public void addInterest();

	public List<Account> getAllAcounts();

	public List<Customer> getAllCustomers();
}
