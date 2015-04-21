package framework.component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import framework.model.*;
import framework.view.*;

public class FinanceHandler {
	protected String name;
	protected IModel model;
	protected List<Customer> customerList;
	protected AGui gui;
	
	
	public void addCustomer(Customer customer) {
		customerList.add(customer);
	}

	public void addInterest() {
		model.addInterest();
	}

	public Customer getCustomer(String customerId) {
		for (Customer customer : customerList) {
			if (customer.getCustomerId().equals(customerId))
				return customer;
		}
		return null;
	}

	public Account getAccount(String accountId) {
		
		//Account account=model.getAllAcounts().get(accountId);
		
		return null;
		//return model.getAllAcounts().get(accountId);
	}
	
	public List<Account> getAllAccount() {
		return model.getAllAcounts();
	}

	public FinanceHandler(IModel iModel) {
		this.model = iModel;
		customerList = new LinkedList<Customer>();
	}

	public void generateReport(Date fromDate, Date toDate, IReport reportType) {
		for (Account account : model.getAllAcounts())
			account.generateReport(fromDate, toDate, reportType);
	}

	public void generateReport(Date fromDate, Date toDate, IReport reportType,
			Account account) {
		account.generateReport(fromDate, toDate, reportType);
	}

	
	public void setGui(AGui gui) {
		this.gui = gui;
	}

	public static void main(String[] args) {
		
		IModel model=new DefaultModel();
		FinanceHandler controller=new FinanceHandler(model);
		AGui gui=new DefaultGui("Financial App",controller);
		controller.setGui(gui);
	}
}
