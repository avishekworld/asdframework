package framework.model;


import java.util.*;

import framework.component.Account;
import framework.component.Customer;
import framework.component.IAccount;
import framework.component.ICustomer;

public class DefaultModel implements IModel {
	public HashMap<String, ICustomer> customerList;
	public HashMap<String, IAccount> accountList;

	public DefaultModel() {
		// TODO Auto-generated constructor stub
		customerList = new HashMap<String, ICustomer>();
		accountList = new HashMap<String, IAccount>();
	}

	public ICustomer getCustomer(String customerId) {
		return customerList.get(customerId);
	}

	public IAccount getAccount(String accountId) {
		return accountList.get(accountId);
	}

	public void addCustomer(ICustomer customer) {
		customerList.put(customer.getCustomerId(), customer);
	}

	public void addInterest() {
			
			List<IAccount> allAccounts=getAllAcounts();
			
			for(IAccount account:allAccounts)
			{
				account.addInterest();
			}
		
	}

	public List<IAccount> getAllAcounts() {
		
		List<IAccount> allAccounts = new ArrayList<IAccount>(accountList.values());
		
		return allAccounts;
	}

	@Override
	public List<ICustomer> getAllCustomers() {

		
		List<ICustomer> allCustomers = new ArrayList<ICustomer>(customerList.values());
		
		return allCustomers;
	}

	@Override
	public void addAccount(IAccount account) {
		// TODO Auto-generated method stub
		accountList.put(account.getAccountNumber(), account);

	}

}
