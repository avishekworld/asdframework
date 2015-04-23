package framework.component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import framework.model.DefaultModel;
import framework.model.IModel;
import framework.view.AGui;
import framework.view.DefaultGui;

public class FinanceSystem {
	protected String name;
	protected IModel model;

	public IModel getModel() {
		return model;
	}

	protected AGui gui;

	public void addCustomer(ICustomer customer) {
		model.addCustomer(customer);
		IAccount account = customer.getLastAddedAccount();
		model.addAccount(account);
	}

	public void addInterest() {
		model.addInterest();
	}


	public IAccount getAccount(String accountId) {
		
		return model.getAccount(accountId);
	}
	
	public List<IAccount> getAllAccount() {
		return model.getAllAcounts();
	}

	public FinanceSystem() {
	
	}

	public void generateReport(Date fromDate, Date toDate, IReport reportType) {
		
		
		for (IAccount account : model.getAllAcounts())
		{
			
			account.generateReport(fromDate, toDate, reportType);
		}
		
		if(model.getAllAcounts().size()>0)
		{
			JOptionPane.showMessageDialog(null, "Report Generated on Report Folder");
		}
		else {
			
			JOptionPane.showMessageDialog(null, "No Account aviailable for report");
		}
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

		FinanceSystem controller = new FinanceSystem();
		
		IModel model = new DefaultModel();
		AGui gui = new DefaultGui("Financial App", controller);
		
		controller.setModel(model);
		controller.setGui(gui);
		
	}

}
