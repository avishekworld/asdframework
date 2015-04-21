package framework.component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import framework.model.DefaultModel;
import framework.model.IModel;
import framework.view.AGui;
import framework.view.DefaultGui;

public class FinanceHandler {
	protected String name;
	protected IModel model;

	public IModel getModel() {
		return model;
	}

	protected List<Customer> customerList;

	public List<Customer> getCustomerList() {
		return customerList;
	}

	protected AGui gui;

	public void addCustomer(Customer customer) {
		customerList.add(customer);
		Account account = customer.getLastAddedAccount();
		model.addAccount(account);
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

		IModel model = new DefaultModel();
		FinanceHandler controller = new FinanceHandler(model);
		HashMap<String, String> guiData = new HashMap<String, String>();

		guiData.put(Account.ACC_NUM_FIELD, "1234");

		guiData.put(Customer.NAME_FIELD, "Sajedul");
		guiData.put(Customer.STREET_FIELD, "1000 N 4th");
		guiData.put(Customer.CITY_FIELD, "Fairfield");
		guiData.put(Customer.ZIP_FIELD, "52557");
		guiData.put(Customer.STATE_FIELD, "Iowa");

		guiData.put(Personal.BIRTH_DATE_FIELD, "02/22/1999");

		ICommand command = new PersonalAccountOpenCommand(controller, guiData);
		command.exceute();

		Account account = new Account(guiData);
		model.addAccount(account);

		AGui gui = new DefaultGui("Financial App", controller);
		controller.setGui(gui);
	}

}
