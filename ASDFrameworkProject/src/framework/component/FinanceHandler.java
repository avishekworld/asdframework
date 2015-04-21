package framework.component;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import framework.model.IModel;
import framework.view.IGui;

public class FinanceHandler {
	protected String name;
	protected IModel model;
	protected List<Customer> customerList;
	protected IGui iGui;

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
		return model.getAllAcounts().get(accountId);
	}

	public FinanceHandler(IModel iModel, IGui iGui) {
		this.model = iModel;
		this.iGui = iGui;
		customerList = new LinkedList<Customer>();
	}

	public void generateReport(Date fromDate, Date toDate, IReport reportType) {
		for (Account account : model.getAllAcounts().values())
			account.generateReport(fromDate, toDate, reportType);
	}

	public void generateReport(Date fromDate, Date toDate, IReport reportType,
			Account account) {
		account.generateReport(fromDate, toDate, reportType);
	}

	public void main() {

	}
}
