package framework.model;


import java.util.*;


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
			
			List<Account> allAccounts=getAllAcounts();
			
			for(Account account:allAccounts)
			{
				account.addInterest();
			}
		
	}

	public List<Account> getAllAcounts() {
		
		List<Account> allAccounts = new ArrayList<Account>(accountList.values());
		
		return allAccounts;
	}

	@Override
	public List<Customer> getAllCustomers() {

		
		List<Customer> allCustomers = new ArrayList<Customer>(customerList.values());
		
		return allCustomers;
	}

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		accountList.put(account.getAccountNumber(), account);

	}

}
