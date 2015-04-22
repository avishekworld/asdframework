package framework.model;


import java.util.*;

import framework.component.Account;
import framework.component.Customer;
import framework.component.IAccount;
import framework.component.ICustomer;

public interface IModel {
	public ICustomer getCustomer(String customerId);

	public IAccount getAccount(String accountId);

	public void addCustomer(ICustomer customer);

	public void addAccount(IAccount account);

	public void addInterest();

	public List<IAccount> getAllAcounts();

	public List<ICustomer> getAllCustomers();
}
