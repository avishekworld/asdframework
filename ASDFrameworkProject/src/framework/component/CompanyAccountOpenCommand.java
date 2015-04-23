package framework.component;

import java.util.HashMap;

import javax.swing.JOptionPane;

public class CompanyAccountOpenCommand implements ICommand {

	FinanceHandler controller;
	HashMap<String, String> guiData;
	AccountType accountType;
	
	public CompanyAccountOpenCommand(FinanceHandler controller,
			HashMap<String, String> guiData, AccountType accountType) {
		this.controller = controller;
		this.guiData = guiData;
		this.accountType=accountType;
	}

	@Override
	public void exceute() {
		
		if(controller.getAccount(guiData.get(Account.ACC_NUM_FIELD))==null)
		{
			ICustomer companyCustomer=new CompanyCustomer(guiData);
			IAccount account=new Account(guiData,accountType);
			companyCustomer.addAccount(account);
			controller.addCustomer(companyCustomer);
			
			//JOptionPane.showMessageDialog(null, "Account "+guiData.get(Account.ACC_NUM_FIELD)+" created");
		}
		else {
			
			JOptionPane.showMessageDialog(null, "Account "+guiData.get(Account.ACC_NUM_FIELD)+" already Exits");
		}
		
		
	}

}
