package framework.model;


import framework.component.*;

public interface IModel
{
	public Customer getCustomer(String customerId);
	public Account getAccount(String accountId);
	public void addCustomer(Customer customer);
	public void addInterest();
	public void getAllAcounts();
}
