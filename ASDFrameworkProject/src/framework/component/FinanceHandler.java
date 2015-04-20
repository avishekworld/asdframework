package framework.component;

import java.util.Date;
import java.util.List;

import framework.model.IModel;
import framework.view.IGui;

public class FinanceHandler {
	protected String name;
	protected IModel model;
	protected List<Customer> customerList;
	protected IGui iGui;

	public void addCustomer(Customer customer) {

	}

	public void addInterest() {

	}

	public Customer getCustomer(String customerId) {
		return null;
	}

	public Account getAccount(String accountId) {
		return null;
	}

	public FinanceHandler(IModel iModel, IGui iGui) {

	}

	public void generateReport(Date fromDate, Date toDate) {

	}

	public void main() {

	}
}
