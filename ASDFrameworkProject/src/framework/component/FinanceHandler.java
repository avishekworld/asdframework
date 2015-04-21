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

	protected AGui gui;

	public void addCustomer(Customer customer) {
		model.addCustomer(customer);
		Account account = customer.getLastAddedAccount();
		model.addAccount(account);
	}

	public void addInterest() {
		model.addInterest();
	}


	public Account getAccount(String accountId) {
		
		return model.getAccount(accountId);
	}
	
	public List<Account> getAllAccount() {
		return model.getAllAcounts();
	}

	public FinanceHandler() {
	
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
	

	public void setModel(IModel model) {
		this.model = model;
	}

	public static void main(String[] args) {

		FinanceHandler controller = new FinanceHandler();
		
		IModel model = new DefaultModel();
		AGui gui = new DefaultGui("Financial App", controller);
		
		controller.setModel(model);
		controller.setGui(gui);
		
		
		
		
		/*HashMap<String, String> guiData = new HashMap<String, String>();

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
		controller.setGui(gui);*/
	}

}
